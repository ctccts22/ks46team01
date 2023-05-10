package ks46team01.admin.inventories.record.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import ks46team01.admin.inventories.record.service.InventoryRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/inventory")
public class InventoryRecordController {

    private final InventoryRecordService inventoryRecordService;
    private final AdminRepository adminRepository;

    @GetMapping("/{inventoryRecordId}")
    public ResponseEntity<InventoryRecord> getInventoryRecord(@PathVariable Long inventoryRecordId) {
        InventoryRecord inventoryRecord = inventoryRecordService.getInventoryRecord(inventoryRecordId);
        return new ResponseEntity<>(inventoryRecord, HttpStatus.OK);
    }

    @PostMapping("/add/{companyId}/{inventoryId}/{amount}/{isExceptional}")
    public ResponseEntity<String> addInventoryRecord(@PathVariable Long companyId, @PathVariable Long inventoryId,
                                               @PathVariable double amount, @PathVariable boolean isExceptional,
                                               HttpSession session) {
        Admin sessionAdmin = (Admin) session.getAttribute("adminUser");
        Optional<Admin> adminOptional = adminRepository.findByAdminUsername(sessionAdmin.getAdminUsername());
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            inventoryRecordService.addInventoryRecord(companyId, inventoryId, amount, isExceptional, admin);
            return new ResponseEntity<>("Inventory added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/remove/{companyId}/{inventoryId}/{amount}")
    public ResponseEntity<String> removeInventoryRecord(@PathVariable Long companyId, @PathVariable Long inventoryId,
                                                  @PathVariable double amount, HttpSession session) {
        Admin sessionAdmin = (Admin) session.getAttribute("adminUser");
        Optional<Admin> adminOptional = adminRepository.findByAdminUsername(sessionAdmin.getAdminUsername());
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            inventoryRecordService.removeInventoryRecord(companyId, inventoryId, amount, admin);
            return new ResponseEntity<>("Inventory removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }
    }
}
