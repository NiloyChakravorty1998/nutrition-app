package service.nutrition.wishlistservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionDto {

    private Long id;

    private String foodItem;

    private String userId;

    private String reqId;
}
