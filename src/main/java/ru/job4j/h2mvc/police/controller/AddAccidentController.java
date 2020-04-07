package ru.job4j.h2mvc.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.h2mvc.police.entity.Accident;
import ru.job4j.h2mvc.police.repository.Repository;

/**
 * @author Vitaly Vasilyev, date: 05.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/accidents")
public class AddAccidentController {
    /**
     * Хранилище правонарушений.
     */
    private final Repository repo;

    /**
     * @param repo хранилище правонарушений.
     */
    @Autowired
    public AddAccidentController(Repository repo) {
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
     * @param name название.
     * @param text описание.
     * @param address адрес.
     * @return перенаправляет на гл.страницу.
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAccident(
            @RequestParam("name") String name,
            @RequestParam("text") String text,
            @RequestParam("address") String address) {
        repo.add(new Accident(name, text, address));
        return "redirect:/accidents";
    }
}