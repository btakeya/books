package books.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/book")
public class BooksController {
    private Logger log = LoggerFactory.getLogger(BooksController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getBook(@RequestParam(value="id", defaultValue="0") int id) {
    	log.debug("[GET] getBook()");
    	return "[GET] " + id;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String postBook(@RequestParam(value="id", defaultValue="0") int id) {
    	log.debug("[POST] postBook()");
    	return "[POST] " + id;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String putBook(@RequestParam(value="id", defaultValue="0") int id) {
    	log.debug("[PUT] putBook()");
    	return "[PUT] " + id;
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteBook(@RequestParam(value="id", defaultValue="0") int id) {
    	log.debug("[DELETE] deleteBook()");
    	return "[DELETE] " + id;
    }
}
