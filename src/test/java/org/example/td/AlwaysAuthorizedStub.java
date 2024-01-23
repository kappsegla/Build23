package org.example.td;

public class AlwaysAuthorizedStub implements Authorizer{
    @Override
    public Boolean authorize(String username, String password) {
        return true;
    }
}
