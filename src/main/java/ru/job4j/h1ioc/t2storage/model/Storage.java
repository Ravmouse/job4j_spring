package ru.job4j.h1ioc.t2storage.model;

import java.util.Map;

/**
 * @author Vitaly Vasilyev, date: 21.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public interface Storage<T> extends AutoCloseable {
    /**
     * @param t добавляемый элемент.
     * @return элемент, который был добавлен в хранилище.
     */
    T add(T t);
    /**
     * Нужно для тестового метода, чтобы по интерфейсу получить мапу для проверки добавленных элементов.
     * @return хэш-мапу для добавляемых элементов.
     */
    default Map<Integer, T> getStorage() {
        return null;
    }
}