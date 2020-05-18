package ru.job4j.h2mvc.police.z;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vitaly Vasilyev, date: 01.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Tes {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Bill", 1, 5));
        cars.add(new Car("John", 2, 100));
        cars.add(new Car("Jack", 3, 45));
        cars.add(new Car("Chuck", 1, 50));
        cars.add(new Car("Sam", 2, 1000));
        cars.add(new Car("Ann", 1, 500));
        cars.add(new Car("John", 2, 10000));
        cars.add(new Car("Spiderman", 1, 5000));

//        System.out.println(cars.stream().collect(Collectors.groupingBy(Car::getId)));
//        System.out.println(cars.stream().collect(Collectors.groupingBy(Car::getId, Collectors.counting())));
        System.out.println(cars.stream().collect(Collectors.groupingBy(
                Car::getId,
                Collectors.mapping(Car::getName, Collectors.maxBy(Comparator.comparing(String::length))))));
    }

}

class Car {
    String name;
    int id;
    int weight;

    public Car(String name, int id, int weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%d", name, id, weight);
    }
}