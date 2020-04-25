package ru.job4j.h2mvc.police.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vitaly Vasilyev, date: 01.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Entity(name = "Accident")
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String text;
    @Column
    private String address;

    public Accident(String name, String text, String address) {
        this.name = name;
        this.text = text;
        this.address = address;
    }

    public Accident() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param o объект для сравнения.
     * @return true, если два экземпляра равны, и false, если - нет.
     * Только по id, если будет использоваться ORM Hibernate.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Accident)) {
            return false;
        }
        Accident accident = (Accident) o;
        return id != 0 && id == accident.id;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return String.format("id=%d,name=%s,text=%s,address=%s", id, name, text, address);
    }
}