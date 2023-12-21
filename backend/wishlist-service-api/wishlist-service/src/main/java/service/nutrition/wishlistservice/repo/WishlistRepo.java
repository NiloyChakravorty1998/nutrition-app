package service.nutrition.wishlistservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.nutrition.wishlistservice.model.NutritionWishlist;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<NutritionWishlist, Long> {
    public List<NutritionWishlist> getAllByUserId(String userId);
}
