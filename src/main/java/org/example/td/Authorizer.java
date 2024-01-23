package org.example.td;

interface Authorizer {
    Boolean authorize(String username, String password);
}
