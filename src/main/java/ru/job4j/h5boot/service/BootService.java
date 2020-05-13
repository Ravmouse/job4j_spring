package ru.job4j.h5boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.h5boot.entity.Acc;
import ru.job4j.h5boot.repository.BootRepository;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 19.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Service
public class BootService {
    /**
     * Репозиторий.
     */
    private final BootRepository repo;

    /**
     * @param repo репозиторий.
     */
    @Autowired
    public BootService(BootRepository repo) {
        this.repo = repo;
    }

    /**
     * @param accident правонарушение для добавления.
     */
    public void add(Acc accident) {
        repo.save(accident);
    }

    /**
     * @return список всех правонарушений.
     */
    public List<Acc> getAll() {
        return repo.getAll();
    }
}