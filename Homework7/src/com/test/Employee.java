/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author eck
 */
class Employee {

    public static enum Gender {

        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
   private UUID еmployeeID;

    private Employee(String name, Gender gender, LocalDate dob,
            double income) {
        
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        this.еmployeeID = UUID.randomUUID();
    }

    public Employee() {
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        // To do
        System.out.println(persons().stream().map(Employee::getIncome).mapToDouble(e -> e).sum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.income, income) == 0 && Objects.equals(name, employee.name) && gender == employee.gender && Objects.equals(dob, employee.dob) && Objects.equals(еmployeeID, employee.еmployeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dob, income, еmployeeID);
    }

    public Gender getGender() {
        return gender;
    }


    // ако не позлваш закоментиранията toString метод, няма нужда от викането на getName() при принтиране
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", gender=" + gender +
//                ", dob=" + dob +
//                ", income=" + income +
//                ", еmployeeID=" + еmployeeID +
//                '}';
//    }


    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void personsStatsByGenderCount() {
        Map<Gender, List<Employee>> genderListMap = persons().stream().collect(Collectors.groupingBy(Employee::getGender));
        genderListMap.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue().size()));
    }

    public void personsStatsByGenderList() {
        Map<Gender, List<Employee>> genderListMap = persons().stream().collect(Collectors.groupingBy(Employee::getGender));
        for (var entry : genderListMap.entrySet()) {
            System.out.print(entry.getKey()+ ": ");
            for (Employee e : entry.getValue()) {
                System.out.print(e.getName() + " ");
            }
            System.out.println();
        }
    }
}

