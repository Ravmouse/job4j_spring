package ru.job4j.h5boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.h5boot.entity.Acc;
import ru.job4j.h5boot.service.BootService;

/**
 * @author Vitaly Vasilyev, date: 13.05.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RestController
public class AddController {
    /**
     * Хранилище правонарушений.
     */
    private final BootService repo;

    /**
     * @param repo хранилище правонарушений.
     */
    @Autowired
    public AddController(BootService repo) {
        this.repo = repo;
    }

    @GetMapping("/accidents/add")
    public ModelAndView menu(ModelAndView model) {
        model.setViewName("add");
        return model;
    }

    @PostMapping("/accidents/add")
    public RedirectView add(@ModelAttribute("acc") Acc acc) {
        repo.add(acc);
        return new RedirectView("/accidents", true);
    }
}