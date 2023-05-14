package com.cs133.planify;
import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Account;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.junit.Assert;

public class DatabaseTest {
    public String TestEmail= "trittp123@gmail.com";
    public String TestPassword= "testpassword123";
    private FirebaseAuth mauth =FirebaseAuth.getInstance();



    public boolean initializeTestLogin(){
        mauth.signInWithEmailAndPassword(TestEmail, TestPassword);
        return true;
    }
    @Test
    public void unitTestTestLogin(){
        assert(initializeTestLogin());
    }

}
