package ru.job4j.h1ioc.t2storage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.job4j.h1ioc.t2storage.entity.User;
import ru.job4j.h1ioc.t2storage.model.Storage;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Vitaly Vasilyev, date: 22.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ImportUser.class)
public class ImportUserTest {
    @Autowired
    private Storage<User> memory;

    @Test
    public void whenUserIsAddedThenStorageHasThisUser() {
        assertNotNull(memory);

        final User user = new User(23, "Pete", "me@mail.ru");
        memory.add(user);
        memory.add(new User(45, "John", "john@ya.ru"));

        assertThat(memory.getStorage().size(), is(2));
        assertThat(memory.getStorage().get(23), is(user));
    }
}