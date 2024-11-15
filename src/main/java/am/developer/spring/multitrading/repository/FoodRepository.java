package am.developer.spring.multitrading.repository;

import am.developer.spring.multitrading.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Foods, Long> {
}
