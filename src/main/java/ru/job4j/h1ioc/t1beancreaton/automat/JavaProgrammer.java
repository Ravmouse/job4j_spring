package ru.job4j.h1ioc.t1beancreaton.automat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vitaly Vasilyev, date: 14.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Component
public class JavaProgrammer implements Programmer {

    private final Ide ide;

    @Autowired
    public JavaProgrammer(Ide ide) {
        this.ide = ide;
    }

    @Override
    public void createApp() {
        ide.start();
    }
}