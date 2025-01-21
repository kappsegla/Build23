package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerReaderTest {

    @Test
    @DisplayName("Find customer by id returns full name of customer")
    void findCustomerByIdReturnsFullNameOfCustomer() {
        EntityManager entityManager = new JohnDoeEntityManager();
        CustomerReader customerReader = new CustomerReader(entityManager);

        var fullName = customerReader.findFullName(1L);

        assertThat(fullName).isEqualTo("John Doe");
    }

}
