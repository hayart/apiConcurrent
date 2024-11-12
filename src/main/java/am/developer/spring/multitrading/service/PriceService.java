package am.developer.spring.multitrading.service;

import am.developer.spring.multitrading.entity.Price;

public interface PriceService {
    Price getPriceByProductId(Long productId);
}
