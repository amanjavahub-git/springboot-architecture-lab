package com.architecturelab.features.aws.s3.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Employee {

    @Schema(description = "Unique identifier for the employee", example = "101")
    private String id;

    @Schema(description = "Full name of the employee", example = "Aman Jaiswal")
    private String name;

    @Schema(description = "Department where employee works", example = "IT")
    private String department;

    // Constructors
    public Employee() {}
    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}