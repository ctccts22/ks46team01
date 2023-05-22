package ks46team01.admin.inventories.log.controller;

import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import ks46team01.admin.inventories.log.mapper.InventoryLogMapper;
import ks46team01.admin.inventories.log.service.InventoryLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/inventory")
public class InventoryLogController {

    private final InventoryLogMapper inventoryLogMapper;
    private final InventoryLogService inventoryLogService;

    @GetMapping("/listInventoryLog")
    public String showInventoryLogList(Model model) {
        List<InventoryLogDTO> inventoryLogDTOList = inventoryLogMapper.listInventoryLog();
        model.addAttribute("title", "재고입출고리스트");
        model.addAttribute("inventoryLogList", inventoryLogDTOList);
        log.info("inventoryLogDTOList:{}", inventoryLogDTOList);
        return "admin/inventory/listInventoryLog";
    }

    @PostMapping("/addInventoryLog")
    public String addInventoryLog(@ModelAttribute("inventoryLog") InventoryLogDTO inventoryLogDTO) {
        inventoryLogService.updateInventoryLogAndInventory(inventoryLogDTO);
        return "redirect:/admin/inventory/listInventoryLog";
    }

}
