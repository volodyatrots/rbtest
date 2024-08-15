package com.rb.lab.tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestAccount {

    @Test
    public void ifGmailAccount() {
        String mail = "mytestmail@gmail.com";
        assertTrue(mail.contains("@gmail.com"));
    }

}
