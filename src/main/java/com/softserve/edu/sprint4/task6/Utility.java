package com.softserve.edu.sprint4.task6;

import java.util.Arrays;
import java.util.Comparator;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

enum Level {
    JUNIOR, MIDDLE, SENIOR
}

class Utility {
    public static <T extends Person> void sortPeople(T[] person, Comparator<? super T> comparator) {
        Arrays.sort(person, comparator);
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int nameComparison = person1.getName().compareTo(person2.getName());
        if (nameComparison == 0) {
            return Integer.compare(person1.getAge(), person2.getAge());
        }
        return nameComparison;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int nameComparison = emp1.getName().compareTo(emp2.getName());
        if (nameComparison == 0) {
            int baseComparison = Integer.compare(emp1.getAge(), emp2.getAge());
            return baseComparison == 0 ? Double.compare(emp1.getSalary(), emp2.getSalary()) : baseComparison;
        }
        return nameComparison;
    }
}

class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer developer1, Developer developer2) {
        int nameComparison = developer1.getName().compareTo(developer2.getName());
        if (nameComparison == 0) {
            int baseComparison = Integer.compare(developer1.getAge(), developer2.getAge());
            return baseComparison == 0 ? developer1.getLevel().compareTo(developer2.getLevel()) : baseComparison;
        }
        return nameComparison;
    }
}
