package com.example.l44_sbmvcthymeleaf.web;

import com.example.l44_sbmvcthymeleaf.CarRepository;
import com.example.l44_sbmvcthymeleaf.domain.CarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    //надо делать через сервисы, с целью экономии внедряем сразу репозиторий
    private final CarRepository repository;

    @GetMapping
    public ModelAndView home(@ModelAttribute(name = "newcar") CarEntity car) {
        var allCars = repository.findAll();

        ModelAndView modelAndView = new ModelAndView("home.html");
        modelAndView.addObject("cars", allCars);

        return modelAndView;
    }

    @PostMapping
    public String save(CarEntity entity) {
        repository.save(entity);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id){
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView detail(@PathVariable(name = "id") Integer id){
        var carFromBD = repository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("details.html");
        modelAndView.addObject("car", carFromBD);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Integer id, CarEntity car){
        repository.save(car);
        return "redirect:/";
    }

}
