package service.nutrition.wishlistservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.nutrition.wishlistservice.dto.NutritionDto;
import service.nutrition.wishlistservice.service.WishlistService;
import service.nutrition.wishlistservice.util.Builder;
import service.nutrition.wishlistservice.vo.request.RequestVO;
import service.nutrition.wishlistservice.vo.response.ResponseVO;
import java.util.List;

@RestController
@RequestMapping("wishlist/api/v1")
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    private final WishlistService service;
    private final Builder build;

    public ApiController(WishlistService service,Builder build) {
        this.build = build;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveNewItem(@RequestBody RequestVO vo) {
        Long reqId = build.getReqId();
        ResponseVO res = new ResponseVO();
        res.setReqId(String.valueOf(reqId));
        NutritionDto dto = new NutritionDto();
        dto.setUserId(vo.getUserId());
        dto.setFoodItem(vo.getItem());
        dto.setReqId(String.valueOf(reqId));
        log.info("Saving new item ");
        try {
            service.saveNewWishlist(dto);
            res.setMessage("Saved Successfully");
        } catch (Exception e) {
            res.setMessage("Error occurred");
            log.error("Error : " + e.getMessage());
            e.printStackTrace();

        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteItem(@RequestBody RequestVO vo) {
        Long reqId = build.getReqId();
        ResponseVO res = new ResponseVO();
        res.setReqId(String.valueOf(reqId));
        log.info("Deleting item ");
        try {
            service.deleteWishlist(vo.getId());
            res.setMessage("Deleted Successfully");
        } catch (Exception e) {
            res.setMessage("Error occurred");
            log.error("Error : " + e.getMessage());
            e.printStackTrace();

        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllItems(@RequestBody RequestVO vo){
        Long reqId = build.getReqId();
        ResponseVO res = new ResponseVO();
        res.setReqId(String.valueOf(reqId));
        log.info("Fetching all items ");
        try {
            List<NutritionDto> dtl = service.getAllByUserId(vo.getUserId());
            res.setAllItems(dtl);
            res.setMessage("Fetched Successfully");
        } catch (Exception e) {
            res.setMessage("Error occurred");
            log.error("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
