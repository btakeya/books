package books.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import books.core.BooksEngine;
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
		
		System.out.println("ID: "+ id);
		return "[GET]" + BooksEngine.getBook(repo, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postBook(@RequestParam(value = "title", required = true) String title,
						   @RequestParam(value = "price", required = true) int price) {
		log.debug("[POST] postBook()");
		
		return "[POST] " + BooksEngine.saveBook(repo, title, price);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String putBook(@RequestParam(value = "id", required = true) long id,
						  @RequestParam(value = "title", required = false) String title,
						  @RequestParam(value = "price", required = false) Integer price) {
		log.debug("[PUT] putBook()");
		
		return "[PUT] " + BooksEngine.updateBook(repo, id, title, price);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteBook(@RequestParam(value = "id", defaultValue = "0") long id) {
		log.debug("[DELETE] deleteBook()");
		
		return "[DELETE] " + BooksEngine.deleteBook(repo, id);
	}
}
