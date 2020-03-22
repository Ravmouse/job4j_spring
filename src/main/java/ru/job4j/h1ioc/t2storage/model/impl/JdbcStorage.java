package ru.job4j.h1ioc.t2storage.model.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.job4j.h1ioc.t2storage.entity.User;
import ru.job4j.h1ioc.t2storage.model.Storage;
import ru.job4j.h1ioc.t2storage.service.Wrapper;
import java.util.Optional;

/**
 * @author Vitaly Vasilyev, date: 21.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Component
public class JdbcStorage implements Storage<User> {
    /**
     * Фабрика для сессий.
     */
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * @param user добавляемый пользователь.
     * @return пользователь, который был добавлен в БД.
     */
    @Override
    public User add(User user) {
        return new Wrapper(factory).perform(session -> {
            session.save(user);
            return user;
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