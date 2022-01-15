package ch.teko.prg3.springdemo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    public FirstController() {
        System.out.println("Constructor from class FirstController is called!");
    }

    @Autowired
    private FirstService firstService;

    @GetMapping
    public DTO greetingsOnScreen(@RequestParam(required = false) String text) {
        return firstService.greetings(text);
    }

}
