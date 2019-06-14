package at.nacs.basket.persistance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Basket {

    private String id;

    private String userUuId;

    @Builder.Default
    private List<ItemDTO> userBasket = new ArrayList<>();
}
