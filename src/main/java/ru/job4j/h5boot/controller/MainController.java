package ru.job4j.h5boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.h5boot.service.BootService;

/**
 * @author Vitaly Vasilyev, date: 13.05.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RestController
public class MainController {
    /**
     * Хранилище правонарушений.
     */
    private final BootService repo;

    /**
     * @param repo хранилище правонарушений.
     */
    @Autowired
    public MainController(BootService repo) {
        this.repo = repo;
    }

    @GetMapping("/accidents")
    public ModelAndView list(ModelAndView model) {
        model.setViewName("accidents");
        model.addObject("accidents", repo.getAll());
        return model;
    }
}