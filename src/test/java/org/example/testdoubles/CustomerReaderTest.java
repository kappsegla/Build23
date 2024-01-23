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
}
