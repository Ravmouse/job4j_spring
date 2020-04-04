package ru.job4j.h2mvc.police.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.job4j.h1ioc.t2storage.service.Wrapper;
import ru.job4j.h2mvc.police.entity.Accident;
import java.util.List;
import java.util.Optional;

/**
 * @author Vitaly Vasilyev, date: 01.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Component
public class AccidentRepository implements Repository {
    /**
     * Фабрика сессий.
     */
    private final SessionFactory factory = new Configuration().configure("springmvc_hiber.cfg.xml").buildSessionFactory();

    /**
     * @return список всех правонарушений.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Accident> getAll() {
        return new Wrapper(factory).perform(session -> {
            final Query query = session.createQuery("from Accident a order by a.id");
            return query.list();
        });
    }

    /**
     * @throws Exception искл.
     */
    @Override
    public void close() throws Exception {
        Optional.ofNullable(factory).ifPresent(f -> factory.close());
    }
}