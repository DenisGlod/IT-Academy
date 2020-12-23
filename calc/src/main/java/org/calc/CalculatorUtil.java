package org.calc;

import java.util.Map;

public class CalculatorUtil {

    public static Double averageSalary(Map<Integer, Double> salary, Integer startMonth, Integer endMonth) {
        isValidMonth(startMonth, endMonth);
        double sum = 0;
        int countMonth = endMonth - startMonth + 1;
        for (int i = startMonth; i <= endMonth; i++) {
            sum += salary.get(i);
        }
        return sum / countMonth;
    }

    private static void isValidMonth(Integer startMonth, Integer endMonth) {
        if (startMonth < 1 || startMonth > 12 || endMonth < 1 || endMonth > 12 || startMonth >= endMonth) {
            throw new IllegalArgumentException("Incorrect period");
        }
    }

}
