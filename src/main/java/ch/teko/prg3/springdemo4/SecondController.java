package ch.teko.prg3.springdemo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {

    @Autowired
    private FirstService firstService;

    @GetMapping(value = "/formular")
    public ModelAndView inputFormGreetings(@RequestParam(required = false) String userName) {
        ModelAndView modelAndView = new ModelAndView("formular_page");
        modelAndView.addObject("dto", firstService.greetings(userName));
        return modelAndView;
    }
}
