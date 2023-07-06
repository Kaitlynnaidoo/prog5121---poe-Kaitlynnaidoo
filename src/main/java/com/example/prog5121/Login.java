/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prog5121;

/**
 *
 * @author Kaitlyn Naidoo <st10083262@vcconnect.edu.za>
 */
public class Login
{

    private String _username = "";
    private String _password = "";
    private String _loginStatusString = "";

    // This function creates validates a username and password and validates it.
    public String registerUser(String username, String password)
    {

        String response = "";

        if (checkUserName(username))
        {
            response += "Username successfully captured\n";
        } else
        {
            response += "Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length.\n";

            // Leave function if the username is not valid.
            return response;
        }

        if (checkPasswordComplexity(password))
        {
            response += "Password successfully captured\n";
        } else
        {
            response += "Password is not correctly formatted, "
                    + "please ensure that the password contains at least 8 "
                    + "characters, a capital letter, a number and a special "
                    + "character.\n";

            // Leave function if the password is not valid.
            return response;
        }

        _username = username;
        _password = password;

        return response;
    }

    public Boolean loginUser(String username, String password)
    {

        // Check if username or password is empty
        if (username == null || username.isEmpty())
        {
            _loginStatusString += "The username cannot be empty.";
            return false;
        }

        if (password == null || username.isEmpty())
        {
            _loginStatusString += "The password cannot be empty.";
            return false;
        }

        // If username and password match the user.
        if (username.equals(_username) && password.equals(_password))
        {
            _loginStatusString += "Welcome " + _username
                    + " ,it is great to see you again.";
            return true;
        } else // If they dont match :(
        {
            _loginStatusString += "Username or password incorrect, please try again";
            return false;
        }

    }
    
    public String returnLoginStatus() {
        return _loginStatusString;
    }
    

    /* Check if the username is less than or equal to 5 characters and
     * contains an underscore.
     */
    public boolean checkUserName(String username)
    {
        if(username == null) return false;
        return !(username.length() > 5 || !username.contains("_"));
    }

    /* Check if the password is longer than 8 characters, contains a capital letter,
     * number and special character.
     */
    public boolean checkPasswordComplexity(String password)
    {
        if(password == null) return false;
        return !(password.length() < 8 || !containsCapitalLetter(password)
                || !containsNumber(password) || !containsSpecialCharacter(password));
    }

    private boolean containsCapitalLetter(String password)
    {
        for (char c : password.toCharArray())
        {
            if (Character.isUpperCase(c))
            {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password)
    {
        for (char c : password.toCharArray())
        {
            if (Character.isDigit(c))
            {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password)
    {
        String specialCharacters = "!@#$%^&*()-_=+[]{};:'\",.<>/?";
        for (char c : password.toCharArray())
        {
            if (specialCharacters.contains(Character.toString(c)))
            {
                return true;
            }
        }
        return false;
    }

}
