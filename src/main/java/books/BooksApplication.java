package books;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class BooksApplication {
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
}
