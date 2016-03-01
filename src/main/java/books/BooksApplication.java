package books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import books.controller.*;

@SpringBootApplication
public class BooksApplication {
	public static void main(String[] args) {
		Object[] servletList = {LostController.class, BooksController.class};
		SpringApplication.run(servletList, args);
	}
}
