package ru.job4j.h1ioc.t1beancreaton.javacfg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertNotNull;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanJavaConfig.class)
public class BeanJavaConfigTest {

    @Autowired
    private Employee employee;

    @Autowired
    private Person person;

    @Test
    public void whenEmployeeIsLoadedThenItIsNotNull() {
        assertNotNull(employee);
    }

    @Test
    public void whenPersonIsLoadedThenItIsNotNull() {
        assertNotNull(person);
    }
}