package at.nacs.basket.communication;

import at.nacs.basket.logic.BasketManager;
import at.nacs.basket.persistance.domain.Basket;
import at.nacs.basket.persistance.domain.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketEndpoint {

    private final BasketManager basketManager;

    @PostMapping
    Basket addItem(@RequestBody ItemDTO itemDTO) {
        Basket basket = basketManager.addItemToBasket(itemDTO);
        return basket;
    }

}
