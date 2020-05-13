package ru.job4j.h5boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.h5boot.entity.Acc;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 13.05.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Repository
public interface BootRepository extends CrudRepository<Acc, Integer> {
    /**
     * @return список всех правонарушений.
     */
    @Query("SELECT a from Acc a")
    List<Acc> getAll();
}