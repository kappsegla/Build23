package org.example.td;

public class NotAuthorizedSpy implements Authorizer {
    public boolean authorizeCalled = false;

    @Override
    public Boolean authorize(String username, String password) {
        authorizeCalled = true;
        return false;
    }
}
