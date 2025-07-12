package com.cognizant.employeeservice.model;

public class Employee {

    private String id;
    private String name;
    private double salary;
    private boolean permanent;
    private Department department;

    public Employee() {}

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public Department getDepartment() {
        return department;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
