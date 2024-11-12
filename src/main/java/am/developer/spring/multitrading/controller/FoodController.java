package am.developer.spring.multitrading.controller;


import am.developer.spring.multitrading.dto.FoodDetailDTO;
import am.developer.spring.multitrading.facade.FoodASyncFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foods")
@Slf4j
public class FoodController {

    private final FoodASyncFacade foodASyncFacade;

    public FoodController(FoodASyncFacade foodASyncFacade) {
        this.foodASyncFacade = foodASyncFacade;
    }

    @GetMapping("/{id}/async")
    public ResponseEntity<FoodDetailDTO> getAsync(@PathVariable Long id) {
        log.info("Rest request to get product by id async: {}", id);
        return ResponseEntity.ok(foodASyncFacade.getDetails(id));
    }

}
