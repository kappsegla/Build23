package org.example.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void initialCompanyNameIsMegadyneInc() {
        assertThat(company.getName()).isEqualTo("Megadyne, Inc.");
    }

    @Test
    public void companyRenamed() {
        String proposedName = "Cybertron Unlimited, Ltd.";

        //Company aCompany = Mockito.spy(this.company);

        company.setName(proposedName);

        //verify(aCompany).setName(proposedName);

        assertThat(company.getName()).isEqualTo("Cybertron Unlimited, Ltd.");
    }

    @Test
    public void leadingTrailingSpacesRemovedFromEmployeeName() {
        Employee employee1 = new Employee("001", " Bob", 100_000.00);
        assertEquals("Bob", employee1.getName());
        Employee employee2 = new Employee("002", "Alice  ", 100_000.00);
        assertEquals("Alice", employee2.getName());
    }

    @Test
    public void employeeAdded() {
        this.company.addEmployee(new Employee("123", "Dave", 100_000.00));
        assertThat(this.company.numberOfEmployees()).isEqualTo(1);

        this.company.addEmployee(new Employee("456", "Bob", 50_000.00));
        assertThat(this.company.numberOfEmployees()).isEqualTo(2);
    }

    @Test
    public void everybodyGetsRaise() {
        double increaseBy = 0.1; // everybody's salary should go up by this fraction

        double davesOriginalSalary = 100_000.00;

        this.company.addEmployee(new Employee("123", "Dave", davesOriginalSalary));
        this.company.addEmployee(new Employee("456", "Alice", 120_000.00));
        this.company.addEmployee(new Employee("789", "Bob", 110_000.00));

        this.company.everybodyGetsRaiseBy(increaseBy);

        Employee dave = this.company.findEmployeeById("123");

        assertEquals(davesOriginalSalary * increaseBy, dave.getSalary(), 0.0001);
    }

    @Test
    public void findEmployeeById() {
        add3Employees();

        Employee hopefullyDave = this.company.findEmployeeById("123");

        assertThat(hopefullyDave).extracting("name").isEqualTo("Dave");

    }

    private void add3Employees() {
        this.company.addEmployee(new Employee("123", "Dave", 100_000.00));
        this.company.addEmployee(new Employee("456", "Alice", 100_000.00));
        this.company.addEmployee(new Employee("789", "Bob", 100_000.00));
    }

    @Test
    void findEmployeeByNonExistentIdReturnsNull() {
        add3Employees();

        Employee hopefullyNoOne = this.company.findEmployeeById("999");

        assertThat(hopefullyNoOne).isNull();
    }

    @Test
    public void employeeNameChanged() {
        add3Employees();

        Employee employee = this.company.findEmployeeById("123");
        employee.setName("Tommy Lee");
        employee = this.company.findEmployeeById("123");
        System.out.println(employee.getName().equals("Tommy Lee") ? "PASSED" : "FAILED");
    }
}
