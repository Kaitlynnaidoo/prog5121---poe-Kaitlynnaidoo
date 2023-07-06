/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prog5121;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaitlyn Naidoo <st10083262@vcconnect.edu.za>
 */
public class Task
{

    /* Make the first task number minus because we will be adding 
     * one to it to each time, so it is 0 initially.
     */
    public static int taskNumberIncrement = -1;

    // This array stores all the tasks.
    public static ArrayList<Task> tasks = new ArrayList<>();
    
    
    public String _taskID;
    public String _taskName;
    public int _taskNumber;
    public String _taskDescription;
    public String _developerDetails;
    public double _taskDuration;
    public String _taskStatus;

    public Task(String _taskName, String _taskDescription, String _developerDetails, double _taskDuration, String _taskStatus)
    {
        this._taskName = _taskName;
        this._taskDescription = _taskDescription;
        this._developerDetails = _developerDetails;
        this._taskDuration = _taskDuration;
        this._taskStatus = _taskStatus;
        taskNumberIncrement += 1;
        this._taskNumber = taskNumberIncrement;
        this._taskID = createTaskID(_taskName, _taskNumber, _developerDetails);
        tasks.add(this);
    }

    public Task() {
        
    }
    
    public void createTask()
    {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Get the task name
        do
        {
            System.out.print("Enter the name of the task to be performed: ");
            userInput = scanner.nextLine();

            if (userInput.isEmpty())
            {
                System.out.println("The name of the task cannot be empty.");
                continue;
            }
            
            if(userInput.length() < 2)
            {
                // For generating the id.
                System.out.println("The name of the task cannot be less than 2 characters.");
            }
            
        } while (userInput.isEmpty() || userInput.length() < 2);

        this._taskName = userInput;

        
        
        // Get the task number
        taskNumberIncrement += 1;
        this._taskNumber = taskNumberIncrement;

        
        
        // Get the task description
        do
        {
            System.out.print("Enter a short description of the task: ");
            userInput = scanner.nextLine();

            if (userInput.length() > 50)
            {
                System.out.println("Please enter a task description of less than 50 characters");
            }
            
            if (userInput.isEmpty())
            {
                System.out.println("The description of the task cannot be empty.");
                continue; // Only show one error at a time.
            }

        } while (checkTaskDescription(userInput));

        this._taskDescription = userInput;
        System.out.println("Task successfully captured");

        // Get the developer details
        do
        {
            System.out.print("Enter the developers Name and Surname assigned "
                    + "to the task: ");
            userInput = scanner.nextLine();

            if (userInput.isEmpty())
            {
                System.out.println("The developers name cannot be empty.");
                continue;
            }

            if (!userInput.contains(" "))
            {
                System.out.println("The input must contain a name and surname.");
                continue;
            }
            
            if(userInput.length() < 2)
            {
                // For generating the id.
                System.out.println("The name of the developer cannot be less than 2 characters.");
            }

        } while (userInput.isEmpty() || !userInput.contains(" ") || userInput.length() < 2);

        this._developerDetails = userInput;

        // Get the task duration.        
        do
        {
            System.out.print("Enter the estimated duration of the task in hours: ");
            userInput = scanner.nextLine();

            if (userInput.isEmpty())
            {
                System.out.println("The estimated duration cannot be empty.");
            }

            try
            {

                this._taskDuration = Double.parseDouble(userInput);
                break; // Exit the loop if the conversion is successful
            } catch (NumberFormatException e)
            {
                System.out.println("The value entered is not a valid number.");
            }
        } while (true);

        // Creat the task ID
        this._taskID = createTaskID(_taskName, _taskNumber, _developerDetails);

        
        // Get the task status
        int choice;
        do {
            
            System.out.println("Select a task status");
            System.out.println("1. To Do");
            System.out.println("2. Done");
            System.out.println("3. Doing");
            System.out.print("Your Choice (1-3): ");
            
            userInput = scanner.nextLine();
            
            try
            {

                choice = Integer.parseInt(userInput);
                if (choice >= 1 && choice <= 3){
                    break; // Exit the loop if the conversion is successful
                } else {
                    System.out.println("Your choice must be between 1 and 3.");
                }
            } catch (NumberFormatException e)
            {
                System.out.println("THe value entered is not a valid number.");
            }
            
        } while (true);
        
        switch(choice) {
            case 1 -> _taskStatus = "To Do";
            case 2 -> _taskStatus = "Done";
            case 3 -> _taskStatus = "Doing";
        } 
        
        tasks.add(this);
    }

    public String createTaskID(String taskName, int taskNumber, String developerDetails)
    {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" 
                + taskNumber + ":" 
                + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskId;
    }

    public static Boolean checkTaskDescription(String userInput)
    {
        if (userInput.isEmpty())
        {
            return true;
        }

        if (userInput.length() > 50)
        {
            return true;
        }
        
        return false;
    }

    public String printTaskDetails()
    {
        String message = "Task Status: " + _taskStatus + "\n" +
                         "Developer Details: " + _developerDetails + "\n" +
                         "Task Number: " + _taskNumber + "\n" +
                         "Task Name: " + _taskName + "\n" +
                         "Task Description: " + _taskDescription + "\n" +
                         "Task ID: " + _taskID + "\n" +
                         "Duration: " + _taskDuration + " Hours";

        JOptionPane.showMessageDialog(null, message, "Task Details", JOptionPane.INFORMATION_MESSAGE);
        
        return message;
    }

    public static int returnTotalHours()
    {
       double sum = 0;
        for (Task obj : tasks)
        {
            sum += obj._taskDuration;
        }

        int roundedSum = Math.round((float) sum);
        return roundedSum;
    }
}
