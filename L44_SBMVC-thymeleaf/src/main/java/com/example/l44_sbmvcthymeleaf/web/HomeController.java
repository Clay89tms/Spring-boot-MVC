package com.example.l44_sbmvcthymeleaf.web;

import com.example.l44_sbmvcthymeleaf.domain.CarDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView home(@RequestParam(name = "role", required = false) String role){
        ModelAndView modelAndView = new ModelAndView("home.html");
        modelAndView.addObject("car", new CarDto("testName", 30));
        modelAndView.addObject("carMap", Map.of("car", new CarDto("testNameFromMap", 40)));
        if("admin".equalsIgnoreCase(role)){
            modelAndView.addObject("isAdmin", true);
        } else {
            modelAndView.addObject("isAdmin", false);
        }
        return modelAndView;
    }

}
