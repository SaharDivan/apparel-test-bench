package at.nacs.basket.logic;

import at.nacs.basket.persistance.domain.Basket;
import at.nacs.basket.persistance.domain.ItemDTO;
import at.nacs.basket.persistance.repository.BasketRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@Log
class BasketManagerTest {

    @Autowired
    BasketManager basketManager;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    @Singleton
    String userUuId;

    @Autowired
    ItemDTO item1;

    @Autowired
    List<ItemDTO> items;

    @Autowired
    Basket basket;


    @BeforeEach
    void before() {
        basketRepository.deleteAll();
    }

    @AfterEach
    void After() {
        basketRepository.deleteAll();
    }


    @Test
    void creatBasketForUser() {

        Basket actual = basketManager.creatBasketForUser(userUuId);
        Basket expected = basketRepository.findByUserUuId(userUuId).get();

        assertThat(actual.getUserUuId()).isEqualTo(expected.getUserUuId());
    }


    @Test
    void addItemToBasket() {
        basketManager.creatBasketForUser(userUuId);
        basketManager.addItemToBasket(item1);
        Basket basket = basketRepository.findByUserUuId(userUuId).get();

        assertThat(basket.getUserBasket()).contains(item1);
    }


    @Test
    void getTheBasket() {
        basketManager.creatBasketForUser(userUuId);

        items.stream()
                .forEach(e -> basketManager.addItemToBasket(e));

        Optional<Basket> basket = basketManager.getTheBasket(userUuId);

        assertThat(basket.get().getUserBasket()).contains(items.get(0));

    }

    @Test
    void deleteItem() {
        Basket testBasket = basketManager.creatBasketForUser(userUuId);
        basketManager.addItemToBasket(item1);
        String itemId = item1.getId();

        basketManager.deleteItem(itemId, userUuId);

        assertThat(testBasket.getUserBasket()).isEmpty();

    }
}