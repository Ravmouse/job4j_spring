package ru.job4j.h2mvc.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.h2mvc.police.entity.Accident;
import ru.job4j.h2mvc.police.repository.SpringDataRepository;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 19.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Service
public class AccidentService {
    /**
     *
     */
    private final SpringDataRepository repo;

    /**
     * @param repo репозиторий.
     */
    @Autowired
    public AccidentService(SpringDataRepository repo) {
        this.repo = repo;
    }

    /**
     * @param accident правонарушение для добавления.
     */
    public void add(Accident accident) {
        repo.save(accident);
    }

    /**
     * @return список всех правонарушений.
     */
    public List<Accident> getAll() {
        return repo.getAll();
    }
}