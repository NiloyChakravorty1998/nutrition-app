package service.nutrition.wishlistservice.util;

import org.springframework.stereotype.Component;
import service.nutrition.wishlistservice.dto.NutritionDto;
import service.nutrition.wishlistservice.model.NutritionWishlist;

@Component
public class Builder {
    public NutritionDto toDto (NutritionWishlist entity) {
        NutritionDto dto = new NutritionDto();
        dto.setFoodItem(entity.getFoodItem());
        dto.setId(entity.getId());
        dto.setReqId(entity.getReqId());
        dto.setUserId(entity.getUserId());
        return dto;
    }
    public NutritionWishlist toEntity(NutritionDto dto){
        NutritionWishlist entity = new NutritionWishlist();
        entity.setFoodItem(dto.getFoodItem());
        entity.setId(dto.getId());
        entity.setReqId(dto.getReqId());
        entity.setUserId(dto.getUserId());
        return entity;
    }
    public Long getReqId() {
        long timestamp = System.currentTimeMillis() / 1000;
        return timestamp;
    }
}
