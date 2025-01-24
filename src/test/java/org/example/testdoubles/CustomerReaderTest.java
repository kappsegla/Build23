package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerReaderTest {

    EntityManager entityManager;

    @Test
    @DisplayName("Find customer by id returns full name of customer")
    void findCustomerByIdReturnsFullNameOfCustomer() {
        EntityManager entityManager = new JohnDoeEntityManager();
        CustomerReader customerReader = new CustomerReader(entityManager);

        var fullName = customerReader.findFullName(1L);

        assertThat(fullName).isEqualTo("John Doe");
    }

    @Test
    @DisplayName("Find customer by id using mockito")
    void findCustomerByIdUsingMockito() {
        //EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(1L)).thenReturn(new Customer(1L, "John","Doe"));

        CustomerReader customerReader = new CustomerReader(entityManager);

        var fullName = customerReader.findFullName(1L);

        assertThat(fullName).isEqualTo("John Doe");
    }


}
