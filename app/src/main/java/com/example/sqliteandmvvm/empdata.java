package com.example.sqliteandmvvm;

public class empdata {
    int id;
    String emp_name;
    String enp_age;
    String emp_salary;
    String emp_address;

    public empdata(int id, String emp_name, String enp_age, String emp_salary, String emp_address) {
        this.id = id;
        this.emp_name = emp_name;
        this.enp_age = enp_age;
        this.emp_salary = emp_salary;
        this.emp_address = emp_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEnp_age() {
        return enp_age;
    }

    public void setEnp_age(String enp_age) {
        this.enp_age = enp_age;
    }

    public String getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(String emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }
}
