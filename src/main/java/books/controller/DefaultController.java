package books.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@RequestMapping()
public class DefaultController {
    @RequestMapping(method = RequestMethod.GET)
	String index() {
		return "On my way.";
	}
}
