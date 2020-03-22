package ru.job4j.h1ioc.t2storage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vitaly Vasilyev, date: 21.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    public User() { }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("id=%d, name=%s, email=%s", id, name, email);
    }

    /**
     * Добавлены имя и почта, чтобы в тестовом методе проверить равенство при добавлении в хэш-мапу и получении из нее.
     * @param o объект для сравнения.
     * @return true или false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id != 0 && id == user.id && name.equals(user.name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}