/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.example.prog5121;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaitlyn Naidoo <st10083262@vcconnect.edu.za>
 */


// To Run Tests, Check the Test Package.
// You can also right click this file or the login class and press Test File.





public class Main
{

    static String[] taskNames =
    {
        "Create Login", "Create Add Features", "Create Reports", "Add Arrays"
    };
    static String[] developers =
    {
        "Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"
    };
    static int[] taskDurations =
    {
        5, 8, 2, 11
    };
    static String[] taskStatuses =
    {
        "To Do", "Doing", "Done", "To Do"
    };
    static String[] taskIds =
    {
        "CR:0:ITH", "CR:1:SON", "CR:2:SON", "AD:3:ZER"
    };

    public static void main(String[] args)
    {

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Register user and Login.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        //String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        //String password = scanner.nextLine();

        Login login = new Login();
        //var result = login.registerUser(username, password);
        //System.out.println(result);

        // If logged in.
        //*************if (login.loginUser(username, password))
        if (true)
        {
            System.out.println(login.returnLoginStatus());

            int choice;
            do
            {
                String input = JOptionPane.showInputDialog(null,
                        "Choose an option:\n"
                        + "1. Populate Arrays\n"
                        + "2. Add Tasks\n"
                        + "3. Show Report\n"
                        + "4. Search\n"
                        + "5. Get Task With Longest Duration\n"
                        + "6. Quit");

                if (input == null)
                {
                    // User clicked Cancel or closed the dialog
                    return;
                }
                try
                {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e)
                {
                    // Invalid input, show error message and try again
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                    continue;
                }
                switch (choice)
                {
                    case 1 -> populateArrays();
                    case 2 -> addTasks();
                    case 3 -> showReport();
                    case 4 -> search();
                    case 5 -> JOptionPane.showMessageDialog(null, getTaskWithLongestDuration());
                    case 6 ->
                    {
                        // Quit
                        return;
                    }
                    default -> // Invalid input, show error message and try again
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid option.");
                }
            } while (true);
        }
    }

    private static void addTasks()
    {

        int choice;

        do
        {
            String input = JOptionPane.showInputDialog(null,
                    "How many tasks do you want to create:");

            if (input == null)
            {
                // User clicked Cancel or closed the dialog
                return;
            }
            try
            {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e)
            {
                // Invalid input, show error message and try again
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            for (int i = 0; i < choice; i++)
            {
                Task task = new Task();
                task.createTask();
                task.printTaskDetails();
            }

            JOptionPane.showMessageDialog(null, "The total task durations is " + Task.returnTotalHours() + " Hours.");
            break;
        } while (true);
    }

    private static void populateArrays()
    {

        for (int i = 0; i < 4; i++)
        {
            Task task = new Task(taskNames[i], null,
                    developers[i], taskDurations[i], taskStatuses[i]);
        }

        JOptionPane.showMessageDialog(null, "The program has been loaded "
                + "with the values provided in the POE from arrays.");
    }

    private static void showReport()
    {
        String message = "Report for all tasks\n\n";
        for (var obj : Task.tasks)
        {
            message += "******************************************\n\n"
                    + "Task Status: " + obj._taskStatus + "\n"
                    + "Developer Details: " + obj._developerDetails + "\n"
                    + "Task Number: " + obj._taskNumber + "\n"
                    + "Task Name: " + obj._taskName + "\n"
                    + "Task Description: " + obj._taskDescription + "\n"
                    + "Task ID: " + obj._taskID + "\n"
                    + "Duration: " + obj._taskDuration + " Hours\n\n";

        }

        JOptionPane.showMessageDialog(null, message, "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void search()
    {
        int choice;

        do
        {
            String input = JOptionPane.showInputDialog(null,
                    "Choose an option\n"
                    + "1. Show all done tasks\n"
                    + "2. Search by task name\n"
                    + "3. Search assigned to developer\n"
            );

            if (input == null)
            {
                // User clicked Cancel or closed the dialog
                return;
            }
            try
            {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e)
            {
                // Invalid input, show error message and try again
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            if (choice < 1 || choice > 3)
            {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            switch (choice)
            {
                case 1 ->
                {
                    String message = "All Done Tasks\n\n";
                    for (int i = 0; i < 4; i++)
                    {
                        if (taskStatuses[i].equals("Done"))
                        {
                            message += "******************************************\n\n"
                                    + "Developer: " + developers[i] + "\n"
                                    + "Task Name: " + taskNames[i] + "\n"
                                    + "Task Duration: " + taskDurations[i] + "\n\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, message, "All Done Tasks", JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 ->
                {
                    String query = JOptionPane.showInputDialog(null,
                        "Enter a name to search");
                    String message = searchForTask(query);
                    JOptionPane.showMessageDialog(null, message, "Search Results", JOptionPane.INFORMATION_MESSAGE);
                                        
                }
                case 3 ->
                {
                    String query = JOptionPane.showInputDialog(null,
                        "Enter a name to search");
                    String message = searchByDeveloperName(query);
                    JOptionPane.showMessageDialog(null, message, "Search Results", JOptionPane.INFORMATION_MESSAGE);
                }

            }

            break;
        } while (true);
    }

    public static String searchForTask(String query)
    {
        String results = "";
        for (int i = 0; i < 4; i++)
        {
            if (taskNames[i].equals(query))
            {
                results += developers[i] + ", " + taskNames[i];
            }
        }
        return results;
    }
    
    public static String searchByDeveloperName(String query)
    {
        String results = "";
        for (int i = 0; i < 4; i++)
        {
            if (developers[i].equals(query))
            {
                results += taskNames[i];
            }
        }
        return results;
    }
    
    public static String getTaskWithLongestDuration()
    {
        int highest = -1;
        int highestIndex = -1;
        for (int i = 0; i < 4; i++)
        {
            if (taskDurations[i] > highest)
            {
                highestIndex = i;
                highest = taskDurations[i];
            }
        }
        if (highestIndex == -1) return "No Tasks.";
        return developers[highestIndex] +  ", " + taskDurations[highestIndex];
    }

}
