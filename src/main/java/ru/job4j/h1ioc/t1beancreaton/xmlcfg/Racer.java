package ru.job4j.h1ioc.t1beancreaton.xmlcfg;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Racer implements Driver {

    @Override
    public void turnWheel() {
        System.out.print("The racer is too fast!");
    }
}