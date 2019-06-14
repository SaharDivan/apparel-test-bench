package at.nacs.basket.communication;

import at.nacs.basket.logic.BasketManager;
import at.nacs.basket.persistance.domain.Basket;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserBasketEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    BasketManager basketManager;

    @Autowired
    String userUuId;

    @Autowired
    Basket basket;

    @Autowired
    Basket newBasket;


    @Test
    void creatBasket() {
        String url = "/userbasket";

        when(basketManager.creatBasketForUser(userUuId)).thenReturn(newBasket);
        Basket actual = testRestTemplate.postForObject(url, userUuId, Basket.class);

        assertThat(actual).isNotNull();
    }

    @Test
    void getBasket() {
        String url = "/userbasket/" + userUuId;
        when(basketManager.getTheBasket(userUuId)).thenReturn(Optional.of(basket));

        Basket actual = testRestTemplate.getForObject(url, Basket.class);

        assertThat(actual).isEqualTo(basket);
    }

}