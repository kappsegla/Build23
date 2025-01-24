package org.example.enough;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    @DisplayName("Create new User")
    void createNewUser() {
        User user = new User("Kalle", 10);

        //Junit5 API version
        assertAll(() -> assertEquals("Kalle", user.getName()),
                () -> assertEquals(10, user.getAge()));

        //AssertJ version
        assertThat(user).extracting("name","age").contains("Kalle",10);
    }

    @Test
    @DisplayName("Equals contract for User")
    void equalsContractForUser() {
        EqualsVerifier.forClass(User.class).verify();
    }

    //Demonstrates the danger with mutable objects and hashCode
//    @Test
//    void test(){
//        Set<User> users = new HashSet<>();
//
//        users.add(new User("Kalle", 10));
//        var user = new User("Kalle", 20);
//        users.add(user);
//        System.out.println(users);
//        user.age=10;
//
//        System.out.println(users);
//    }
}
