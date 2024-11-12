package am.developer.spring.multitrading.service.impl;

import am.developer.spring.multitrading.entity.Price;
import am.developer.spring.multitrading.repository.PriceRepository;
import am.developer.spring.multitrading.service.PriceService;
import am.developer.spring.multitrading.utility.DelayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByProductId(Long id) {
        log.info("Getting price for the id {}", id);
        DelayUtil.addDelay();
        return priceRepository.findByProductId(id);
    }

}
