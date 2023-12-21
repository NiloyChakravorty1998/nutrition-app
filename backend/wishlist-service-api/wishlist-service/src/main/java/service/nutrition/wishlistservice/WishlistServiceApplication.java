package service.nutrition.wishlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WishlistServiceApplication {
	public static void main(String[] args) {
		System.out.println("Starting Wishlist API :");
		SpringApplication.run(WishlistServiceApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void run(){

	}

}
