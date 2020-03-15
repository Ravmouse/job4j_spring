package ru.job4j.h1ioc.t1beancreaton.javacfg;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Student implements Person {

    @Override
    public void read() {
        System.out.println("Read the Math!");
    }
}