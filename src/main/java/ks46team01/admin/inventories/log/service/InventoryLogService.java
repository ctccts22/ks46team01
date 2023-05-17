package ks46team01.admin.inventories.log.service;

import ks46team01.admin.coffee.mapper.CoffeeMapper;
import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import ks46team01.admin.inventories.log.mapper.InventoryLogMapper;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class InventoryLogService {

    private final InventoryLogMapper inventoryLogMapper;
    private final CoffeeMapper coffeeMapper;


//    public void updateCoffeeDeliveryStatus(Long coffeeDeliveryIdx) {
//        CoffeeDelivery coffeeDelivery = coffeeMapper.getCoffeeRequestById(coffeeDeliveryIdx);
//
//        if (!coffeeDelivery.getCoffeeDeliveryStatus().equals("Y")) {
//            CoffeeRequest coffeeRequest = coffeeMapper.getCoffeeRequestById(coffeeDelivery.getCoffeeRequestIdx());
//
//            InventoryLogDTO inventoryLogDTO = new InventoryLogDTO();
//            inventoryLogDTO.setInventoryIdx(coffeeRequest.getInventoryIdx());
//            inventoryLogDTO.setCompanyInfoIdx(coffeeRequest.getCompanyInfoIdx());
//            inventoryLogDTO.setAmount(Double.valueOf(coffeeRequest.getCoffeeRequestAmount()));
//            inventoryLogDTO.setTransactionType("I");
//            inventoryLogDTO.setAdminUsername(coffeeDelivery.getUsername());
//
//            updateInventoryLogAndInventory(inventoryLogDTO);
//        }
//
//        coffeeMapper.updateDelivery(coffeeDeliveryIdx);
//    }


    public void updateInventoryLogAndInventory(InventoryLogDTO inventoryLogDTO) {

        inventoryLogMapper.insertInventoryLog(inventoryLogDTO);

        if ("I".equals(inventoryLogDTO.getTransactionType())) {
            inventoryLogMapper.addInventorySum(inventoryLogDTO.getInventoryIdx(), inventoryLogDTO.getAmount());
        } else if ("O".equals(inventoryLogDTO.getTransactionType())) {
            inventoryLogMapper.subtractInventorySum(inventoryLogDTO.getInventoryIdx(), inventoryLogDTO.getAmount());
        }
    }

}
