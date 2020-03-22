package ru.job4j.h1ioc.t2storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.job4j.h1ioc.t2storage.entity.User;
import ru.job4j.h1ioc.t2storage.model.Storage;
import ru.job4j.h1ioc.t2storage.model.impl.JdbcStorage;

/**
 * @author Vitaly Vasilyev, date: 21.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Configuration
@ComponentScan
public class ImportUser {
    /**
     * Хранилище в БД.
     */
    private final Storage<User> storage;

    /**
     * @param storage хранилище в БД.
     */
    @Autowired
    public ImportUser(Storage<User> storage) {
        this.storage = storage;
    }

    public static void main(String[] args) {
        ImportUser iu = new ImportUser(new JdbcStorage());
        iu.storage.add(new User("Bob", "bob@abc.com"));
    }
}