package ks46team01.admin.inventories.log.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import ks46team01.admin.inventories.log.entity.InventoryLog;
import ks46team01.admin.inventories.log.repository.InventoryLogRepository;
import ks46team01.admin.inventories.log.service.InventoryLogService;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/inventory")
public class InventoryLogController {
    private final CompanyInfoRepository companyInfoRepository;
    private final InventoryRepository inventoryRepository;

    private final InventoryLogRepository inventoryLogRepository;
    private final InventoryLogService inventoryLogService;


    @GetMapping("/listInventoryLog")
    public String showInventoryLogList(Model model) {
        List<InventoryLog> inventoryLogList = inventoryLogRepository.findAll();
        List<Inventory> Inventories = inventoryRepository.findAll();
        List<CompanyInfo> companyInfos = companyInfoRepository.findAll();

        List<String> inventoryTypes = Inventories
                .stream()
                .map(Inventory::getInventoryType)
                .collect(Collectors.toList());

        List<String> companyInfoNames = companyInfos
                .stream()
                .map(CompanyInfo::getCompanyInfoName)
                .collect(Collectors.toList());


        model.addAttribute("title", "재고입출고리스트");
        model.addAttribute("inventoryLogList", inventoryLogList);
        model.addAttribute("inventoryTypes", inventoryTypes);
        model.addAttribute("companyInfoNames", companyInfoNames);
        log.info("inventoryLogList:{}", inventoryLogList);
        return "admin/inventory/listInventoryLog";
    }

    @PostMapping("/addInventoryLog")
    public String addInventoryLog(@ModelAttribute InventoryLogDTO inventoryLogDTO, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            inventoryLogService.addInventoryLogAndInventory(inventoryLogDTO, admin);
        }
        return "redirect:/admin/inventory/listInventoryLog";
    }
}
