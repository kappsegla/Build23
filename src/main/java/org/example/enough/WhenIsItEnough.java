package org.example.enough;

public class WhenIsItEnough {

    public static String greeting(int value) {
        if (value < 0) {
            return "Invalid value";
        } else if (value > 100) {
            return "Invalid value";
        }
        return "A great value";
    }

    public static void setAdminEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }



}
