package am.developer.spring.multitrading.service.impl;

import am.developer.spring.multitrading.entity.Inventory;
import am.developer.spring.multitrading.repository.InventoryRepository;
import am.developer.spring.multitrading.service.InventoryService;
import am.developer.spring.multitrading.utility.DelayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        log.info("Getting inventory for the productId {}", productId);
        DelayUtil.addDelay();
        return inventoryRepository.findByProductId(productId);
    }

}
