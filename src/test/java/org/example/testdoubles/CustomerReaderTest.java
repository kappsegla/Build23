package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CustomerReaderTest {


    @Test
    void findFullNameWithValidIdReturnsFullNameOfCustomer() {

        var entityManager = Mockito.mock(EntityManager.class);
        Customer customer = new Customer(1,"Kalle","Anka");
        Mockito.when(entityManager.find(1L)).thenReturn(customer);
        CustomerReader customerReader = new CustomerReader(entityManager);

        String fullName = customerReader.findFullName(1L);

        assertEquals("Kalle Anka", fullName);
    }

    @Test
    void callingFindFullNameWithInvalidIdReturnsEmptyString() {
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(2L)).thenReturn(null);
        CustomerReader customerReader = new CustomerReader(entityManager);

        String fullName = customerReader.findFullName(2L);

        assertEquals("", fullName);
    }



}