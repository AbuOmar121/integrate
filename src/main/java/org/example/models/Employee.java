package org.example.models;

public class Employee
{
    private int id;
    private String firstName;
    private String lastname;
    private double salary;
    private int status;
    private String result;
    private boolean isread;
    private int departmentId;

    public Employee(int id, String firstName, String lastname, double salary, int status, String result, boolean isread, int departmentId)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
        this.status = status;
        this.result = result;
        this.isread = isread;
        this.departmentId = departmentId;
    }

    public Employee(String firstName, String lastname, double salary, int status, String result, boolean isread, int departmentId)
    {
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
        this.status = status;
        this.result = result;
        this.isread = isread;
        this.departmentId = departmentId;
    }
    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
