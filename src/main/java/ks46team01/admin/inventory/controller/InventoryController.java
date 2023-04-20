package ks46team01.admin.inventory.controller;


import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.admin.inventory.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/listInventory")
    public String inventoryList(Model model) {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        model.addAttribute("title", "재고물품관리");
        model.addAttribute("inventoryList" , inventoryList);
        log.info("inventoryList={}", inventoryList);
        return "admin/inventory/listInventory";
    }
}
