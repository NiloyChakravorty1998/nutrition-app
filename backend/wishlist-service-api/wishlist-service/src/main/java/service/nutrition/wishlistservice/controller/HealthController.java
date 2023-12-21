package service.nutrition.wishlistservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping
    public String getStatus(){
        return "<html><body><center> Server is UP and Running </center></body></html>";
    }
}
