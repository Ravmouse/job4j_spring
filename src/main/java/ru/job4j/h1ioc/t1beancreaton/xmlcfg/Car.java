package ru.job4j.h1ioc.t1beancreaton.xmlcfg;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Car {

    private final Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    public void drive() {
        driver.turnWheel();
    }
}