package at.nacs.basket.logic;

import at.nacs.basket.persistance.domain.Basket;
import at.nacs.basket.persistance.domain.ItemDTO;
import at.nacs.basket.persistance.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketManager {

    private final BasketRepository basketRepository;


    public Basket creatBasketForUser(String userUuId) {
        if(isNotExist(userUuId)){
            Basket basket = Basket.builder().userUuId(userUuId).build();
            Basket savedBasket = basketRepository.save(basket);
            return savedBasket;
        }
        return getTheBasket(userUuId).get();
    }

    public Optional<Basket> getTheBasket(String userUuId) {
        return basketRepository.findByUserUuId(userUuId);
    }

    public Basket addItemToBasket(ItemDTO itemDTO) {
        String userUuid = itemDTO.getUserUuid();
        Basket basket = getTheBasket(userUuid).get();

        List<ItemDTO> userBasket = basket.getUserBasket();
        userBasket.add(itemDTO);
        basket.setUserBasket(userBasket);
        Basket savedBasket = basketRepository.save(basket);
        return savedBasket;
    }

    public void deleteItem(String id, String userUuid){
        Basket basket = basketRepository.findByUserUuId(userUuid).get();

        basket.setUserBasket(
                basket.getUserBasket().stream()
                    .filter(e -> !e.getId().equals(id))
                    .collect(Collectors.toList())
        );

    }

    Boolean isNotExist(String userUuId){
        return getTheBasket(userUuId).isEmpty();

    }

}
