package org.app;

import org.calc.CalculatorUtil;
import org.model.Employee;

import java.util.TreeMap;

public class App {

    public static void main(String[] args) {
        try {
            var employee1 = new Employee();
            employee1.setName("Tim");
            generateMoney(employee1);
            System.out.println("Employee 1: " + employee1);
            System.out.println("Average Salary 1: " + CalculatorUtil.averageSalary(employee1.getSalary(), 5, 9));
            System.out.println("-------------------");
            var employee2 = new Employee();
            employee2.setName("Ban");
            generateMoney(employee2);
            System.out.println("Employee 2: " + employee2);
            System.out.println("Average Salary 2: " + CalculatorUtil.averageSalary(employee2.getSalary(), 1, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateMoney(Employee employee) {
        var salary = new TreeMap<Integer, Double>();
        for (int i = 1; i < 13; i++) {
            double value = 500 + (int) (Math.random() * 1500);
            salary.put(i, value);
        }
        employee.setSalary(salary);
    }

}
