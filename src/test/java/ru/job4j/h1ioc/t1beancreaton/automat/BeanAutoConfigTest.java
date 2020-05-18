package ru.job4j.h1ioc.t1beancreaton.automat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Vitaly Vasilyev, date: 14.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanAutoConfig.class)
public class BeanAutoConfigTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    Programmer programmer;

    @Test
    public void whenBeanIsCreatedThenItIsNotNull() {
        assertNotNull(programmer);
    }

    @Test
    public void whenOutputPrintsThenItEqualsToMsg() {
        programmer.createApp();
//        assertEquals("The Ide is running!", systemOutRule.getLog());
    }
}