package ru.job4j.h1ioc.t1beancreaton.automat;

import org.springframework.stereotype.Component;

/**
 * @author Vitaly Vasilyev, date: 14.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Component
public class IntelliJ implements Ide {

    public void start() {
        System.out.print("The Ide is running!");
    }
}