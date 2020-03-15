package ru.job4j.h1ioc.t1beancreaton.javacfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vitaly Vasilyev, date: 15.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Configuration
public class BeanJavaConfig {

    @Bean
    public Employee employee() {
        return new Manager();
    }

    @Bean
    public Person person() {
        return new Student();
    }
}