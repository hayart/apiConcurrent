package am.developer.spring.multitrading.service;

import am.developer.spring.multitrading.entity.Inventory;

public interface InventoryService {
    Inventory getInventoryByProductId(Long productId);
}
