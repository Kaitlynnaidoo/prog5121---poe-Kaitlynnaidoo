/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.prog5121;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kaitlyn Naidoo <st10083262@vcconnect.edu.za>
 */
public class LoginTest
{

    // These are valid username and passwords for testing.
    private final String _validUsername = "_kait";
    private final String _validPassword = "Abc12345678#";

    public LoginTest()
    {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception
    {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception
    {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception
    {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception
    {
    }

    @org.junit.jupiter.api.Test
    public void test1_username_formatted_correctly()
    {
        String username = "kyl_1";

        Login login = new Login();
        login.registerUser(username, _validPassword);
        login.loginUser(username, _validPassword);
        var result = login.returnLoginStatus();
        assertEquals("Welcome kyl_1 ,it is great to see you again.", result);

    }

    @org.junit.jupiter.api.Test
    public void test2_username_formatted_incorrectly()
    {
        String username = "“kyle!!!!!!!";

        Login login = new Login();
        var result = login.registerUser(username, _validPassword);
        assertEquals("Username is not correctly formatted, please "
                + "ensure that your username contains an underscore and is no "
                + "more than 5 characters in length.\n", result);
    }
    
    @org.junit.jupiter.api.Test
    public void test3_password_meets_complexity_requirements()
    {
        String password = "Ch&&sec@ke99!";

        Login login = new Login();
        var result = login.registerUser(_validUsername, password);
        
        /* Compare the second line only since the first should be password
         * successfully captured.
         */
        
        String[] lines = result.split("\n");
        String secondLine = lines[1];
        assertEquals("Password successfully captured", secondLine);
    }
    
    @org.junit.jupiter.api.Test
    public void test4_password_doesnt_meet_complexity_requirements()
    {
        String password = "password";

        Login login = new Login();
        var result = login.registerUser(_validUsername, password);
        
        /* Compare the second line only since the first should be password
         * successfully captured.
         */
        
        String[] lines = result.split("\n");
        String secondLine = lines[1];
        assertEquals("Password is not correctly formatted, please "
                + "ensure that the password contains at least 8 characters, a "
                + "capital letter, a number and a special"
                + " character.", secondLine);
    }
    
    @org.junit.jupiter.api.Test
    public void test5_login_successful()
    {

        Login login = new Login();
        login.registerUser(_validUsername, _validPassword);
        
        assertTrue(login.loginUser(_validUsername, _validPassword));
        
    }
    
    @org.junit.jupiter.api.Test
    public void test6_login_failed()
    {

        Login login = new Login();
        
        // I put an an invalid password
        login.registerUser(_validUsername, "12345678");
        
        assertFalse(login.loginUser(_validUsername, _validPassword));
        
    }
    
    @org.junit.jupiter.api.Test
    public void test7_username_formatted_correctly()
    {

        Login login = new Login();
        assertTrue(login.checkUserName(_validUsername));

    }

    @org.junit.jupiter.api.Test
    public void test8_username_formatted_incorrectly()
    {
        Login login = new Login();
        assertFalse(login.checkUserName("username"));
    }
    
    @org.junit.jupiter.api.Test
    public void test9_password_meets_complexity_requirements()
    {

        Login login = new Login();
        assertTrue(login.checkPasswordComplexity(_validPassword));

    }

    @org.junit.jupiter.api.Test
    public void test10_password_doesnt_meet_complexity_requirements()
    {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

}
