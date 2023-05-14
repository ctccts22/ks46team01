package ks46team01.admin.inventories.inventory.controller;


import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.admin.inventories.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;

    @GetMapping("/listInventory")
    public String inventoryList(Model model) {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        model.addAttribute("title", "재고관리");
        model.addAttribute("inventoryList", inventoryList);
        log.info("inventoryList={}", inventoryList);
        return "admin/inventory/listInventory";
    }

    @PostMapping("/addInventory")
    @ResponseBody
    public ResponseEntity<?> addInventory(@RequestParam(name = "inventoryIdx", required = false) Long inventoryIdx,
                                          @RequestParam(name = "inventoryType", required = false) String inventoryType,
                                          @RequestParam(name = "inventorySum", required = false) Double inventorySum,
                                          @RequestParam(value = "inventoryDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inventoryDate,
                                          HttpSession session) {

        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            if (inventorySum == null) {
                inventorySum = 0.0;
            }
            InventoryDTO addedInventoryDTO = inventoryService.addCompanyContract(inventoryIdx, inventoryType, inventorySum, inventoryDate, admin);
            if (addedInventoryDTO == null) {
                return new ResponseEntity<>("400에러", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("200성공", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("401어드민로그인에러", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/deleteInventory")
    @ResponseBody
    public ResponseEntity<?> deleteInventory(@RequestParam("inventoryIdx") Long inventoryIdx, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            boolean isDeleted = inventoryService.deleteInventory(inventoryIdx, admin);
            if (isDeleted) {
                return new ResponseEntity<>("200성공", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("400에러", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("401어드민로그인에러", HttpStatus.UNAUTHORIZED);
    }

}