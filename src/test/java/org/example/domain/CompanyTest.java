package org.example.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompanyTest {
    private Company company;

    @BeforeEach
    public void setUp() {
        this.company = new Company("Megadyne, Inc.");
    }

    @AfterEach
    public void tearDown() {
        this.company = null;
    }

    @Test
    public void companyRenamed() {
        String proposedName = "Cybertron Unlimited, Ltd.";

        Company aCompany = Mockito.spy(this.company);

        aCompany.setName(proposedName);

        verify(aCompany).setName(proposedName);

        aCompany.getName();
    }

    @Test
    public void leadingTrailingSpacesRemovedFromEmployeeName() {
        Employee employee1 = new Employee("001", " Bob", 100_000.00);
        assertEquals("Bob", employee1.getName());
        Employee employee2 = new Employee("002", "Alice  ", 100_000.00);
        assertEquals("Alice", employee2.getName());
        Employee employee3 = new Employee("003", "Donald Duck", 100_000.00);
        assertEquals("Donald Duck", employee3.getName());
        Employee employee4 = new Employee("003", "", 100_000.00);
        assertEquals("", employee4.getName());

    }

    @Test
    public void oneEmployeeAdded() {
        this.company.addEmployee(new Employee("123", "Dave", 100_000.00));

        assertEquals(1, this.company.numberOfEmployees());
    }

    @Test
    public void TwoEmployeesAdded() {
        this.company.addEmployee(new Employee("123", "Dave", 100_000.00));
        this.company.addEmployee(new Employee("456", "Bob", 50_000.00));
        assertEquals(2, this.company.numberOfEmployees());
    }

    @Test
    public void everybodyGetsRaise() {
        double increaseBy = 0.1; // everybody's salary should go up by this fraction

        double davesOriginalSalary = 100_000.00;

        this.company.addEmployee(new Employee("123", "Dave", davesOriginalSalary));
        this.company.addEmployee(new Employee("456", "Alice", 100_000.00));
        this.company.addEmployee(new Employee("789", "Bob", 100_000.00));

        this.company.everybodyGetsRaiseBy(increaseBy);

        Employee dave = this.company.findEmployeeById("123");

        assertEquals(110_000.0, dave.getSalary(),0.0001);
    }

    @Test
    public void findEmployeeById() {
        addThreeEmployees(100_000.00);

        Employee hopefullyDave = this.company.findEmployeeById("123");

        //sassertEquals(new Employee("123", "Dave",  100_000.00), hopefullyDave);
        assertEquals("123", hopefullyDave.getId());
        assertEquals("Dave", hopefullyDave.getName());
        assertEquals(100_000.00, hopefullyDave.getSalary());
    }

    private void addThreeEmployees(double newSalary) {
        this.company.addEmployee(new Employee("123", "Dave", newSalary));
        this.company.addEmployee(new Employee("456", "Alice", newSalary));
        this.company.addEmployee(new Employee("789", "Bob", newSalary));
    }

    @Test
    @DisplayName("Given company with employess when findEmployeeById with invalid id then return null")
    void givenCompanyWithEmployessWhenFindEmployeeByIdWithInvalidIdThenReturnNull() {
        addThreeEmployees(100_000.00);

        Employee hopefullyNoOne = this.company.findEmployeeById("999");

        assertNull(hopefullyNoOne);
    }
}
