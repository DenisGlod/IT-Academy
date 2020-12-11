package org.model;

import java.util.TreeMap;

public class Employee {

    private String name;

    private TreeMap<Integer, Double> salary;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public TreeMap<Integer, Double> getSalary() {
	return salary;
    }

    public void setSalary(TreeMap<Integer, Double> salary) {
	this.salary = salary;
    }

    @Override
    public String toString() {
	StringBuilder sbSalary = new StringBuilder();
	salary.forEach((k, v) -> {
	    sbSalary.append(v).append(" ");
	});
	StringBuilder builder = new StringBuilder();
	builder.append("Employee [name=");
	builder.append(name);
	builder.append(", salary=");
	builder.append(sbSalary);
	builder.append("]");
	return builder.toString();
    }

}
