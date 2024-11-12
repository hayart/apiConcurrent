package am.developer.spring.multitrading.facade;

import am.developer.spring.multitrading.dto.FoodDetailDTO;
import am.developer.spring.multitrading.entity.Inventory;
import am.developer.spring.multitrading.entity.Price;
import am.developer.spring.multitrading.entity.Foods;
import am.developer.spring.multitrading.service.InventoryService;
import am.developer.spring.multitrading.service.PriceService;
import am.developer.spring.multitrading.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class FoodASyncFacade {

    private final FoodService foodService;

    private final InventoryService inventoryService;

    private final PriceService priceService;

    public FoodASyncFacade(FoodService foodService, InventoryService inventoryService, PriceService priceService) {
        this.foodService = foodService;
        this.inventoryService = inventoryService;
        this.priceService = priceService;
    }

    public CompletableFuture<Foods> getProductById(long productId) {
        return CompletableFuture
                .supplyAsync(() -> foodService.findById(productId));
    }

    public CompletableFuture<Price> getPriceByProductById(long productId) {
        return CompletableFuture
                .supplyAsync(() -> priceService.getPriceByProductId(productId));
    }

    public CompletableFuture<Inventory> getInventoryByProductId(long productId) {
        return CompletableFuture
                .supplyAsync(() -> inventoryService.getInventoryByProductId(productId));
    }


    public FoodDetailDTO getDetails(long id) {

        //fetch all async
        CompletableFuture<Foods> productFuture = getProductById(id);
        CompletableFuture<Price> priceFuture = getPriceByProductById(id);
        CompletableFuture<Inventory> inventoryFuture = getInventoryByProductId(id);

        //wait for all futures to complete
        CompletableFuture.allOf(priceFuture, productFuture, inventoryFuture);

        //combine the result
        Foods foods = productFuture.join();
        Price price = priceFuture.join();
        Inventory inventory = inventoryFuture.join();

        //build and return

        return new FoodDetailDTO(id, foods.getCategory().getName(),
                foods.getName(), foods.getDescription(),
                inventory.getAvailableQuantity(), price.getPrice(),
                inventory.getStatus());

    }
}
