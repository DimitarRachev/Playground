/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.time.LocalDate;

/**
 *
 * @author eck
 */
public class StreamLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SummaryStatistics stats = new SummaryStatistics();
        stats.setup();

        stats.averageWithJava();
        stats.statsWithStreamReduce();
        stats.allStatsWithStream();

        stats.statsWithStreamAverage();
        stats.statsWithStreamMin();
        stats.statsWithStreamReduce();

        stats.setupCompanies();
        stats.companyStats();
        stats.companyStatsWithStreamAverage();
        
        Employee.statistics();
        // код за тестване на допълнителните методи, не знам дали е нужен за домашното
        Employee employee = new Employee();
        employee.personsStatsByGenderCount();
        employee.personsStatsByGenderList();
    }

}
