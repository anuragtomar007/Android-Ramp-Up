package com.example.dell.androidramp_up;

public class DataModel {
    String name;
    String designation;
    String empId;

    public DataModel(String name, String designation, String empId) {
        this.name = name;
        this.designation = designation;
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmpId() {
        return empId;
    }
}
