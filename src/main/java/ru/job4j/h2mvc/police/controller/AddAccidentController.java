package ru.job4j.h2mvc.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.h2mvc.police.entity.Accident;
import ru.job4j.h2mvc.police.repository.Repository;
import ru.job4j.h2mvc.police.service.AccidentService;

/**
 * @author Vitaly Vasilyev, date: 05.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/accidents")
@ControllerAdvice
public class AddAccidentController {
    /**
     * Хранилище правонарушений.
     */
//    private final Repository repo;
    private final AccidentService repo;

    /**
     * @param repo хранилище правонарушений.
     */
    @Autowired
    public AddAccidentController(AccidentService repo) {
        this.repo = repo;
    }

    /**
     * @return имя view-страницы.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAccidents() {
        return "add";
    }

    /**
     * @param accident правонарушение для добавления в БД.
     * @return перенаправляет на гл.страницу.
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAccident(@ModelAttribute("accident") Accident accident) {
        repo.add(accident);
        return "redirect:/accidents";
    }
}