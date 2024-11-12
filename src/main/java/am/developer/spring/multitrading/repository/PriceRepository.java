package am.developer.spring.multitrading.repository;

import am.developer.spring.multitrading.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findByProductId(Long id);
}
