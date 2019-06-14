package at.nacs.basket.communication;

import at.nacs.basket.logic.BasketManager;
import at.nacs.basket.persistance.domain.Basket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userbasket")
@RequiredArgsConstructor
public class UserBasketEndpoint {

    private final BasketManager basketManager;

    @PostMapping
    Basket creatBasket(@RequestBody String userUuId) {
        Basket basket = basketManager.creatBasketForUser(userUuId);
        return basket;
    }

    @GetMapping("{userUuId}")
    Optional<Basket> getBasket(@PathVariable String userUuId) {
        return basketManager.getTheBasket(userUuId);
    }

    @DeleteMapping("{userUuId}")
    void deleteItem(@RequestBody String itemId, @PathVariable String userUuid){
        basketManager.deleteItem(itemId,userUuid);
    }


}
