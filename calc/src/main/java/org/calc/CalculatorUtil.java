package org.calc;

import java.util.TreeMap;

public class CalculatorUtil {

    public static Double averageSalary(TreeMap<Integer, Double> salary, Integer startMonth, Integer endMonth)
	    throws Exception {
	if (startMonth < 1 || startMonth > 12 || endMonth < 1 || endMonth > 12 || startMonth >= endMonth) {
	    throw new Exception("Incorrect period");
	}
	double sum = 0;
	int countMonth = endMonth - startMonth + 1;
	for (int i = startMonth; i <= endMonth; i++) {
	    sum += salary.get(i);
	}
	return sum / countMonth;
    }

}
