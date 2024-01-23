package org.example.td;

public class DataBaseAuthorizer implements Authorizer{
    @Override
    public Boolean authorize(String username, String password) {
        throw new IllegalCallerException("Do not call from tests");
    }
}
