package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerReaderTest {

    @Test
    @DisplayName("Given Non existing customer id then return empty string")
    void givenNonExistingCustomerIdThenReturnEmptyString() {
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        CustomerReader customerReader = new CustomerReader(entityManager);

        var result = customerReader.findFullName(123L);

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Given existing customer id then return customer first and last name concatenated")
    void givenExistingCustomerIdThenReturnCustomerFirstAndLastNameConcatenated() {
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        CustomerReader customerReader = new CustomerReader(entityManager);
        Customer customer = new Customer(1,"Donald","Duck");
        Mockito.when(entityManager.find(1L)).thenReturn(customer);

        var result = customerReader.findFullName(1L);

        assertThat(result).isEqualTo("Donald Duck");
    }
}
