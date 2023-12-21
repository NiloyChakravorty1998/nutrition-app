package service.nutrition.wishlistservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NUTRITION_WISHLIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NUTRITION_WISHLIST_ID")
    private Long id;

    @Column(name = "FOOD_ITEM")
    private String foodItem;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "REQ_ID")
    private String reqId;
}
