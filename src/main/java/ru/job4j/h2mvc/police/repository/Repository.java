package ru.job4j.h2mvc.police.repository;

import ru.job4j.h2mvc.police.entity.Accident;
import java.util.List;

/**
 * @author Rav, date: 04.04.2020
 * @version 1.0
 */
public interface Repository extends AutoCloseable {
    /**
     * @return список всех правонарушений.
     */
    List<Accident> getAll();
    /**
     * @param accident правонарушение.
     */
    void add(Accident accident);
}