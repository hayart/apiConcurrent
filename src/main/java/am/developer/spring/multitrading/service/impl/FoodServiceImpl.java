package am.developer.spring.multitrading.service.impl;

import am.developer.spring.multitrading.entity.Foods;
import am.developer.spring.multitrading.repository.FoodRepository;
import am.developer.spring.multitrading.service.FoodService;
import am.developer.spring.multitrading.utility.DelayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Foods findById(Long id) {
        log.info("Service request to fetch product by id: {}", id);
        DelayUtil.addDelay();
        return foodRepository.findById(id).orElse(null);
    }


}
