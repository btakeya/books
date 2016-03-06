package books.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@RequestMapping("/")
public class LostController {
    @RequestMapping(method = RequestMethod.GET)
	String lost() {
		return "You're lost!";
	}
}
