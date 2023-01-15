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

        do {
            System.out.println("Login or make new account?");
            System.out.println("Type \"Login\" to login and \"new\" to make a new account");
            Scanner loginAnswer = new Scanner(System.in);
            loginChoice = loginAnswer.nextLine();
            loginChoice = loginChoice.toLowerCase();
        } while (!loginChoice.equals("login") && !loginChoice.equals("new"));

        Scanner userInput = new Scanner (System.in);
        Scanner passInput = new Scanner (System.in);
        int numOfLines = 0;
        try {
            numOfLines = method.findAmountOfLines("LoginDetails.txt");
        }catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        }
        try {
            String[] importedData = method.saveData(numOfLines, "LoginDetails.txt");
            System.out.println(Arrays.toString(importedData));
        }catch (FileNotFoundException e ) {
            System.out.print("FileNotFoundException");
        }

        switch(loginChoice) {
            case "new" :
                System.out.println("Please enter a username and password");
                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();

                System.out.println("Password: ");
                password = userInput.nextLine();


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

                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();

                System.out.println("Password: ");
                password = userInput.nextLine();


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