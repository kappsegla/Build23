package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    @Test
    public void employeeNameChanged() {
        Employee employee = new Employee("123", "Dave", 100_000.0);

        employee.setName("Tommy Lee");

        assertEquals("Tommy Lee", employee.getName());
    }
}
