package at.nacs.basket.configuration;

import at.nacs.basket.persistance.domain.Basket;
import at.nacs.basket.persistance.domain.ItemDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class BasketConfiguration {


    @Bean
    String userUuId() {
        return String.valueOf(UUID.randomUUID());
    }

    @Bean
    Basket basket() {
        return Basket.builder()
                .userUuId(userUuId())
                .userBasket(items())
                .build();
    }


    @Bean
    List<ItemDTO> items() {
        return List.of(
                item1(),
                item2(),
                item3()
        );
    }

    @Bean
    ItemDTO item1() {
        return ItemDTO.builder()
                .id("1")
                .userUuid(userUuId())
                .name("shoes")
                .booked(true)
                .build();
    }

    @Bean
    ItemDTO item2() {
        return ItemDTO.builder()
                .id("2")
                .userUuid(userUuId())
                .name("shirt")
                .booked(true)
                .build();
    }

    @Bean
    ItemDTO item3() {
        return ItemDTO.builder()
                .id("3")
                .userUuid(userUuId())
                .name("hat")
                .booked(true)
                .build();
    }


    @Bean
    Basket newBasket() {
        return Basket.builder()
                .userUuId(userUuId())
                .build();
    }
}
