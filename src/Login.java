import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;


public class Login {

    public static void main(String[] args) {

        File file = new File("LoginDetails.txt");
        Methods method = new Methods();
        String loginChoice;
        String username;
        String password;
        String userpass;
        String userpassFile;
        int lineAmountLD;
        File userFile;
        String[] fileInfo = {"a", "b"};

        try {
            if (file.exists()) {
                System.out.println("File already exists - " + file.getName());
            } else {
                file.createNewFile();
                System.out.println("File created");
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        do {
            System.out.println("Login or make new account?");
            System.out.println("Type \"Login\" to login and \"new\" to make a new account");
            Scanner loginAnswer = new Scanner(System.in);
            loginChoice = loginAnswer.nextLine();
            loginChoice = loginChoice.toLowerCase();

        } while (!loginChoice.equals("login") && !loginChoice.equals("new"));
        //Menu choice, either make new account or login*

        Scanner userInput = new Scanner(System.in);
        Scanner passInput = new Scanner(System.in);
        int numOfLines;

        try {
            numOfLines = method.findAmountOfLines("LoginDetails.txt");
            //finds number of lines in Logindetails

            String[] importedData = method.saveData(numOfLines, "LoginDetails.txt");
            //saves all lines in logindetails

            System.out.println(Arrays.toString(importedData));
            //prints out all information in logindetails


        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } //finds and saves and data in login details

        switch (loginChoice) {
            /*
            Makes new account
            And makes new file for them
            Puts their account into file
             */

            case "new":

                System.out.println("Please enter a username and password");
                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();

                System.out.println("Password: ");
                password = passInput.nextLine();
                username = username.replaceAll("\\s", "");
                password = password.replaceAll("\\s", "");
                //prints username and password and saves as variables
                userpass = username + password;
                userpassFile = userpass + ".txt";

                try {
                    FileWriter myWriter = new FileWriter("LoginDetails.txt", true);
                    //enUserpass = method.userpassEncrypt(username,password);
                    myWriter.close();


                } catch (IOException e) {
                    System.out.println("IOException");
                }
                method.addToDoc("LoginDetails.txt", userpass);
                //method.makeFile(userpassFile);
                method.addToDoc(userpassFile, "userpass: " + userpass);


            case "login":

                System.out.println("Login -");
                System.out.println("Username: ");
                username = userInput.nextLine();
                username = username.toLowerCase();

                System.out.println("Password: ");
                password = passInput.nextLine();

                username = username.replaceAll("\\s", "");
                password = password.replaceAll("\\s", "");

                userpass = username + password;
                userpassFile = userpass + ".txt";


                userFile = new File(userpassFile);
                System.out.println("Account Found: " + method.newFindUser(userpass));


                try {
                    lineAmountLD = method.findAmountOfLines(userpassFile);
                    fileInfo = method.saveData(lineAmountLD, userpassFile);

                } catch (FileNotFoundException e) {
                    try {
                        userFile.createNewFile();
                        method.addToDoc(userpassFile, "Username:" + username);
                        method.addToDoc(userpassFile, "Password:" + password);
                        lineAmountLD = method.findAmountOfLines(userpassFile);
                        fileInfo = method.saveData(lineAmountLD, userpassFile);

                    } catch (IOException ex) {
                        System.out.print("IOException");
                    }

                }
                //System.out.println(Arrays.toString(fileInfo));
                String writeReadChoice;


                do {

                    Scanner writeRead = new Scanner(System.in);
                    writeReadChoice = writeRead.next();
                    writeReadChoice = writeReadChoice.toLowerCase();
                    switch (writeReadChoice) {
                        case "read":
                            System.out.println(Arrays.toString(fileInfo));
                            break;


                        case "write":
                            System.out.print("What to add to file");
                            Scanner writeIn = new Scanner(System.in);
                            String writeInX = writeIn.next();
                            try {
                                FileWriter writeWriter = new FileWriter(userpassFile, true);
                                writeWriter.write(writeInX + "\r\n");
                                writeWriter.close();
                            } catch (IOException e) {
                                System.out.print("IOException");
                            }
                            break;

                        case "end":
                            System.exit(0);
                            break;

                        default:
                            if (!writeReadChoice.equals("stop")) {
                                System.out.println("\"Read\" or \"Write\"");
                            }


                    }
                } while (!writeReadChoice.equals("stop"));


        }
    }
}
