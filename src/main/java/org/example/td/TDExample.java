package org.example.td;

class TDExample {

    private final Authorizer authorizer;

    private String protectedResource = "Authorized Personnel Only";

    public TDExample(Authorizer authorizer) {
        this.authorizer = authorizer;
    }

    public void DoStuff(){
        var authorized = authorizer.authorize("user","P@ssw0rd");
        if( authorized ){
            protectedResource = "User was here!";
        }
    }
}
