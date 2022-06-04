/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author eck
 */
public class SummaryStatistics {

    private List<Double> numbers = new ArrayList<Double>();
    private List<Company> companies = new ArrayList<Company>();
    private Random rand = new Random();

    private class Company {

        private double revenue;

        public Company(double revenue) {
            this.revenue = revenue;
        }

        /**
         * Get the value of revenue
         *
         * @return the value of revenue
         */
        public double getRevenue() {
            return revenue;
        }

    }

    public void setupCompanies() {

        for (int i = 0; i < 10; i++) {
            companies.add(new Company(rand.nextInt(101) / 10.0));
        }
    }

    public void setup() {
        for (int i = 0; i < 10; i++) {
            numbers.add(rand.nextInt(101) / 10.0);
        }
    }

    public double companyStats() {
        DoubleSummaryStatistics stats = companies.stream()
                .collect(Collectors.summarizingDouble(Company::getRevenue));
        System.out.println("Company stats: " + stats);// print all the statistics!!!
        return stats.getAverage();
    }

    public double companyStatsWithStreamAverage() {
        // mapToDouble because it is a stream specialized to work with primitives!!!
         // ToDo
        return  companies.stream().map(Company::getRevenue).mapToDouble(Double::doubleValue).average().getAsDouble(); // return the average
    }

    public double averageWithJava() {
        double sum = 0d;
        for (double number : numbers) {
            sum += number;
        }
        double average = numbers.size() > 0 ? sum / numbers.size() : 0d;
        System.out.println("Java Numbers average: " + average);
        return average;
    }

    public double statsWithStreamAverage() {
        // mapToDouble because it is a stream specialized to work with primnitives!!!
        OptionalDouble average = numbers.stream().mapToDouble(Double::doubleValue).average();
        System.out.println("Stream Numbers average: " + average);
        return average.getAsDouble();
    }

    public double statsWithStreamMin() {
        // mapToDouble because it is a stream specialized to work with primnitives!!!
        OptionalDouble min = numbers.stream().mapToDouble(Double::doubleValue).min();
        System.out.println("Stream Numbers min: " + min);
        return min.getAsDouble();
    }

    public double statsWithStreamReduce() {
        // Find the sum
        Optional<Double> sum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("Stream Numbers sum: " + sum);
        return sum.get();
    }

    public double allStatsWithStream() {
        // Find the sum
        DoubleSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingDouble(Double::doubleValue));
        //return stats.getAverage();
        // return stats.getCount();
        // return stats.getMin(); 
        System.out.println(stats);// print all the statistics!!!
        System.out.println("Stream Numbers all stats: " + stats);
        return stats.getSum();
    }
}
