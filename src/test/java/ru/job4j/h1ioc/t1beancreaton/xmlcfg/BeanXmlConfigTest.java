package ru.job4j.h1ioc.t1beancreaton.xmlcfg;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class BeanXmlConfigTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenBeanIsLoadedThenItExists() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        final Driver racer = context.getBean(Racer.class);
        assertNotNull(racer);

        Car car = new Car(racer);
        assertNotNull(car);

        car.drive();
//        assertEquals("The racer is too fast!", systemOutRule.getLog());
    }
}