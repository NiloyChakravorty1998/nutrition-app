package service.nutrition.wishlistservice.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import service.nutrition.wishlistservice.dto.NutritionDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {
    private String message;
    private String reqId;
    @Nullable
    private List<NutritionDto> allItems;
}
