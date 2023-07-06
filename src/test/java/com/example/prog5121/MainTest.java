/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.prog5121;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kaitlyn Naidoo <st10083262@vcconnect.edu.za>
 */
public class MainTest
{
    
    public MainTest()
    {
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test of searchByName method, of class Main.
     */
    @Test
    public void searchForTasks()
    {
        String query = "Create Login";
        String result = Main.searchForTask(query);
        assertEquals("Mike Smith, Create Login", result);
    }
    
    @Test
    public void searchAllTasksAssignedToDeveloper()
    {
        String query = "Samantha Paulson";
        String result = Main.searchByDeveloperName(query);
        assertEquals("Create Reports", result);
    }

    @Test
    public void displayLongestDuration()
    {
        String result = Main.getTaskWithLongestDuration();
        assertEquals("Glenda Oberholzer, 11", result);
    }
    
}
