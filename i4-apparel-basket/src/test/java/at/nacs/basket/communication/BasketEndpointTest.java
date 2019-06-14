package at.nacs.basket.communication;

import at.nacs.basket.logic.BasketManager;
import at.nacs.basket.persistance.domain.Basket;
import at.nacs.basket.persistance.domain.ItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import javax.inject.Singleton;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BasketEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    BasketManager basketManager;


    @Autowired
    @Singleton
    String userUuId;

    @Autowired
    ItemDTO item1;

    @Autowired
    Basket newBasket;


    String url = "/basket";


    @Test
    void addItem() {

        newBasket.setUserBasket(Arrays.asList(item1));
        when(basketManager.addItemToBasket(item1)).thenReturn(newBasket);
        Basket basket = testRestTemplate.postForObject(url, item1, Basket.class);
        assertThat(basket.getUserBasket()).contains(item1);

    }
}
