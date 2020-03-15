package ru.job4j.utils;

import org.apache.log4j.Logger;

/**
 * @author Vitaly Vasilyev, date: 14.03.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Utils {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = Logger.getLogger(getNameOfTheClass());

    /**
     * Выкидывается исключение и, ввиду того, что этот метод должен запускаться из другого класса, получается имя
     * класса, из которого был вызван данный метод.
     * @return имя класса в виде строки, из которого был выполнен этот метод.
     */
    public static String getNameOfTheClass() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException re) {
            return re.getStackTrace()[1].getClassName();
        }
    }

    /**
     * Находится файл-ресурс и от начала его пути удаляется строка "file:/".
     * @param fileName имя файла-ресурса.
     * @return путь до файла-ресурса.
     */
    public static String getResourcePath(final String fileName) {
        final String temp = Utils.class.getClassLoader().getResource(fileName).toExternalForm();
        return temp.substring(temp.indexOf("C"), temp.length());
    }
}