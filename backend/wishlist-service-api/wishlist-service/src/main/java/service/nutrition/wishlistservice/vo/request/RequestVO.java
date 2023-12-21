package service.nutrition.wishlistservice.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestVO {
    private String userId;
    @Nullable
    private String item;
    @Nullable
    private Long id;
}
