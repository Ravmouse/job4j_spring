package ru.job4j.h2mvc.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.h2mvc.police.repository.Repository;
import ru.job4j.h2mvc.police.service.AccidentService;

/**
 * @author Vitaly Vasilyev, date: 01.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class IndexController {
    /**
     * Хранилище правонарушений.
     */
//    private final Repository repo;
    private final AccidentService repo;

    /**
     * @param repo хранилище правонарушений.
     */
    @Autowired
    public IndexController(AccidentService repo) {
        this.repo = repo;
    }

    /**
     * @param model модель.
     * @return название файла view.
     */
    @RequestMapping(value = "/accidents", method = RequestMethod.GET)
    public String showAccidents(ModelMap model) {
        model.addAttribute("accidents", repo.getAll());
        return "index";
    }
}