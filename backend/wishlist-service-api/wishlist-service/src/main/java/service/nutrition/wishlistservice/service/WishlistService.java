package service.nutrition.wishlistservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.nutrition.wishlistservice.dto.NutritionDto;
import service.nutrition.wishlistservice.model.NutritionWishlist;
import service.nutrition.wishlistservice.repo.WishlistRepo;
import service.nutrition.wishlistservice.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService {
    private static final Logger log = LoggerFactory.getLogger(WishlistService.class);
    private final WishlistRepo repo;
    private final Builder build;
    public WishlistService(WishlistRepo repo, Builder build) {
        this.repo = repo;
        this.build = build;
    }

    public void saveNewWishlist(NutritionDto dto){
        NutritionWishlist entity = new NutritionWishlist();
        log.info("Calling saveNewWishlist service for reqId : " +dto.getReqId());
        try{
            entity = build.toEntity(dto);
            repo.save(entity);
        }catch (Exception e){
            log.error("Error : " +e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteWishlist(Long id){
        log.info("Calling deleteWishlist service for ID  : " +id);
        try{
            repo.deleteById(id);
        }catch (Exception e){
            log.error("Error : " +e.getMessage());
            e.printStackTrace();
        }
    }

    public List<NutritionDto> getAllByUserId(String userId){
        log.info("Calling getAllByUserId for : " +userId);
        List<NutritionWishlist> list = new ArrayList<>();
        try {
            list = repo.getAllByUserId(userId);
        }catch (Exception e){
            log.error("Error : " +e.getMessage());
            e.printStackTrace();
        }
        List<NutritionDto> dtl = list.stream().map(entity -> build.toDto(entity)).collect(Collectors.toList());
        return dtl;
    }
}
