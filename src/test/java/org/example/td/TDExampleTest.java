package org.example.td;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class TDExampleTest {

    @Test
    @DisplayName("Authorized user can change protected resource")
    void authorizedUserCanChangeProtectedResource() {
        Authorizer authorizer = new AlwaysAuthorizedStub();
        TDExample tdExample = new TDExample(authorizer);

        tdExample.doStuff();

        assertThat(tdExample.getProtectedResource()).isEqualTo("User was here!");
    }

    @Test
    @DisplayName("Non authorized user can't change protected resource")
    void nonAuthorizedUserCanTChangeProtectedResource() {
        NotAuthorizedSpy authorizer = new NotAuthorizedSpy();
        TDExample tdExample = new TDExample(authorizer);

        tdExample.doStuff();

        assertThat(tdExample.getProtectedResource()).isEqualTo("Authorized Personnel Only");
        assertThat(authorizer.authorizeCalled).isTrue();
    }

    @Test
    @DisplayName("Authorized user using mockito")
    void authorizedUserUsingMockito() {
        Authorizer authorizer = Mockito.mock(Authorizer.class);
        when(authorizer.authorize(anyString(), anyString())).thenReturn(true);

        TDExample tdExample = new TDExample(authorizer);

        tdExample.doStuff();

        assertThat(tdExample.getProtectedResource()).isEqualTo("User was here!");
    }

    @Test
    @DisplayName("Non authorized user can't change protected resource")
    void nonAuthorizedUserCanTChangeProtectedResourceUsingMock() {
        Authorizer authorizer = Mockito.mock(Authorizer.class);
        when(authorizer.authorize(anyString(), anyString())).thenReturn(false);

        TDExample tdExample = new TDExample(authorizer);

        tdExample.doStuff();

        assertThat(tdExample.getProtectedResource()).isEqualTo("Authorized Personnel Only");
        Mockito.verify(authorizer,Mockito.atLeastOnce()).authorize(Mockito.eq("user"),anyString());
    }

}
