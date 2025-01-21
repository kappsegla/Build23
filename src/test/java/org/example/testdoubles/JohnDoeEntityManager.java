package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;

public class JohnDoeEntityManager implements EntityManager {
    @Override
    public Customer find(Long customerID) {
        if( customerID == 1L)
            return new Customer(1L,"John","Doe");
        return null;
    }

    @Override
    public void persist(Customer customer) {

    }

    @Override
    public void flush() {

    }
}
