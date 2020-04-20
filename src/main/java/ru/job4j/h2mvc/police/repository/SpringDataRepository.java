package ru.job4j.h2mvc.police.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.h2mvc.police.entity.Accident;
import java.util.List;

/**
 * @author Vitaly Vasilyev, date: 19.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Repository
public interface SpringDataRepository extends CrudRepository<Accident, Integer> {
    /**
     * @return список всех правонарушений.
     */
    @Query("SELECT a from Accident a")
    List<Accident> getAll();
}