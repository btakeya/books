package books.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import books.model.*;
import books.repository.BooksRepository;

@ComponentScan
@RestController
@RequestMapping("/books")
public class BooksController {
	private Logger log = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	private BooksRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public String getBook(@RequestParam(value = "id", defaultValue = "-1") long id) {
		log.debug("[GET] getBook()");
		StringBuffer sb = new StringBuffer();
		try {
			if (id < 0) {
				List<Book> bookList = repo.findAll();
				if (bookList.size() > 0) {
					for (Book book : bookList) {
						sb.append(book.toString());
					}
				} else {
					sb.append("Empty Book List");
				}
			} else {
				Book book = repo.getOne(id);
				sb.append(book.toString());
			}
		} catch (Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			sb.append(errorMessage);
		}
		return sb.toString();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postBook(@RequestParam(value = "title", required = true) String title,
						   @RequestParam(value = "price", required = true) int price) {
		log.debug("[POST] postBook()");
		Book newBook = new Book(0, title, price);
		repo.save(newBook);
		return "[POST] " + newBook.toString();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String putBook(@RequestParam(value = "id", required = true) long id,
						  @RequestParam(value = "title", required = false) String title,
						  @RequestParam(value = "price", required = false) Integer price) {
		log.debug("[PUT] putBook()");
		Book updatedBook = repo.getOne(id);
		if (title != null) updatedBook.setTitle(title);
		if (price != null) updatedBook.setPrice(price);
		repo.save(updatedBook);
		return "[PUT] " + updatedBook.toString();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteBook(@RequestParam(value = "id", defaultValue = "0") long id) {
		log.debug("[DELETE] deleteBook()");
		Book deletedBook = repo.getOne(id);
		repo.delete(id);
		return "[DELETE] " + deletedBook.toString();
	}
}
