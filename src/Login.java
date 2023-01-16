import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Login {

    public static void main(String[] args) {

        File file = new File("LoginDetails.txt");
        System.out.println();
        Methods method = new Methods();
        String loginChoice;
        String username;
        String password;
        String userpass;
        int lineAmountLD;
        Scanner UserFileReader;
        String[] fileInfo = {"a", "b"};

        /*
        try {
            method.ifmakeFile("LoginDetails");
        }catch (IOException e) {
            System.out.println("IOException");
        }*/

        try {
            if (file.exists()) {
                System.out.println("File already exists - " + file.getName());
            } else {
                file.createNewFile();
                System.out.println("File created");
            }
        }   catch (IOException e) {
            System.out.println("IOException");
        }
        //checks if file is made or not and makes new one

        do {
            System.out.println("Login or make new account?");
            System.out.println("Type \"Login\" to login and \"new\" to make a new account");
            Scanner loginAnswer = new Scanner(System.in);
            loginChoice = loginAnswer.nextLine();
            loginChoice = loginChoice.toLowerCase();
        } while (!loginChoice.equals("login") && !loginChoice.equals("new"));
        //Menu choice, either make new account or login*

        Scanner userInput = new Scanner (System.in);
        Scanner passInput = new Scanner (System.in);
        int numOfLines = 0;

        try {
            numOfLines = method.findAmountOfLines("LoginDetails.txt");
            //finds number of lines in Logindetails

            String[] importedData = method.saveData(numOfLines, "LoginDetails.txt");
            //saves all lines in logindetails

            System.out.println(Arrays.toString(importedData));
            //prints out all information in logindetails


        }catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } //finds and saves and data in login details

        switch(loginChoice) {
            /*
            Makes new account
            And makes new file for them
            Puts their account into file
             */

            case "new" :

                System.out.println("Please enter a username and password");
                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();
                System.out.println("Password: ");
                password = userInput.nextLine();
                //prints username and password and saves as variables
                userpass = (username + password);

                try {
                    FileWriter myWriter = new FileWriter("LoginDetails.txt", true);
                    myWriter.write(userpass + "\r\n");
                    myWriter.close();


                }catch (IOException e) {
                    System.out.println("IOException");
                }
                method.makeFile(userpass);


            case "login" :
            /*
            Login
            tells user to make account if user not found
            Needs method to check array or file
            Opens file of user and reads inside

             */

                System.out.println("Login -");
                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();
                System.out.println("Password: ");
                password = userInput.nextLine();
                userpass = username + password;
                //takes in username and password as inputs

                userpass = userpass + ".txt";
                File userFile = new File(userpass);
                //makes token 2.0 and makes new file variable


                    try {
                        lineAmountLD = method.findAmountOfLines(userpass);
                        UserFileReader = new Scanner(userFile);
                        fileInfo = method.saveData(lineAmountLD, userpass);
                    }catch (FileNotFoundException e) {
                        System.out.print("FileNotFoundException");
                    }
                    System.out.print(Arrays.toString(fileInfo));



                    try {
                    Scanner loginFinder = new Scanner(new FileInputStream("LoginDetails.txt"));
                    while (loginFinder.hasNextLine()) {
                        String loginDetails = loginFinder.nextLine();
                        if (username.equals(loginDetails)) {
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.print("FileNotFoundException");
                    break;
                }




        }
    }
}