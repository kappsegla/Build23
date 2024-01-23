package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerReaderTest {

    @Mock
    EntityManager entityManager;
    @InjectMocks
    CustomerReader customerReader;

//    @BeforeEach
//    void beforeEach(){
//        entityManager = Mockito.mock(EntityManager.class);
//        customerReader = new CustomerReader(entityManager);
//    }

    @Test
    @DisplayName("Given Non existing customer id then return empty string")
    void givenNonExistingCustomerIdThenReturnEmptyString() {
        var result = customerReader.findFullName(123L);

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Given existing customer id then return customer first and last name concatenated")
    void givenExistingCustomerIdThenReturnCustomerFirstAndLastNameConcatenated() {
        Customer customer = new Customer(1,"Donald","Duck");
        Mockito.when(entityManager.find(1L)).thenReturn(customer);

        var result = customerReader.findFullName(1L);

        assertThat(result).isEqualTo("Donald Duck");
    }
}
