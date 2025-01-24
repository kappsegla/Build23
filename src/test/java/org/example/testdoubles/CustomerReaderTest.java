package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerReaderTest {

    @Mock
    EntityManager entityManager;

    @InjectMocks
    CustomerReader customerReader;

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
        when(entityManager.find(1L)).thenReturn(new Customer(1L, "John", "Doe"));

        var fullName = customerReader.findFullName(1L);

        assertThat(fullName).isEqualTo("John Doe");
    }


}
