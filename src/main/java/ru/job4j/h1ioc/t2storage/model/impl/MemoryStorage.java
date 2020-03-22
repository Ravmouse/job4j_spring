package ru.job4j.h1ioc.t2storage.model.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.job4j.h1ioc.t2storage.entity.User;
import ru.job4j.h1ioc.t2storage.model.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Vitaly Vasilyev, date: 21.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Component
@Primary
public class MemoryStorage implements Storage<User> {
    /**
     * Хэш-мапа для пользователей.
     */
    private final Map<Integer, User> storage = new HashMap<>();

    /**
     * Нужно для тестового метода, чтобы по интерфейсу получить мапу и начать проверять в ней.
     * @return хэш-мапу для добавляемых пользователей.
     */
    @Override
    public Map<Integer, User> getStorage() {
        return storage;
    }

    /**
     * @param user пользователь.
     * @return добавленного в мапу пользователя.
     */
    @Override
    public User add(User user) {
        return storage.putIfAbsent(user.getId(), user);
    }

    /**
     * @throws Exception искл.
     */
    @Override
    public void close() throws Exception {
        Optional.of(storage).ifPresent(Map::clear);
    }
}