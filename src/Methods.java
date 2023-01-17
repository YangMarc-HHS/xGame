import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class Methods {
    public boolean newFindUser (String userpass) {
        try {
            return Files.readAllLines(Path.of("LoginDetails.txt")).contains(userpass);
        } catch (IOException e){
            System.out.println("IOException");
            return false;
        }
    }
    //finds user from login details
    /*
    public boolean findUser (String userpass) throws IOException {

        Scanner loginFinder = null;
        try {
            loginFinder = new Scanner(new FileInputStream("LoginDetails.txt"));
            while (loginFinder.hasNextLine()) {
                String loginDetails = loginFinder.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } finally {
            loginFinder.close();
            return Files.readAllLines(Path.of("LoginDetails.txt")).contains(userpass);
        }



    }*/



    public boolean addToDoc (String fileNameWithTxt, String stringGoingToAddedToDoc) {

        PrintWriter xWriter = null;
        boolean result = true;
        try {
            xWriter = new PrintWriter(fileNameWithTxt);
            xWriter.print(stringGoingToAddedToDoc);
            return true;
        }catch (IOException e) {
            System.out.print("IOException");
            return false;

        }finally {
            xWriter.close();
        }

    }
    //takes in file and string, and writes string to file

    public int findAmountOfLines (String fileNameWithTxt) throws FileNotFoundException {
        File file = new File(fileNameWithTxt);
        int lineAmount= 0;
        Scanner lineCounter = new Scanner(file);
        while(lineCounter.hasNextLine()) {
            lineCounter.nextLine();
            lineAmount++;
        }
        return lineAmount;
    }
    //finds the amount of lines in a file
    public int rollTen (int pity, int pity2) {
        int rolls[];
        int rollNum;
        for (int i = 0; i<10; i++) {
            if (pity < 75) {
                rollNum = (int) ((double) Math.random()*101);

            }
        }
        return 10;
    }
    //ten roll - not finished yet
    public String[] saveData (int lineAmount, String fileNameWithTxt) throws FileNotFoundException{
        File file = new File(fileNameWithTxt);
        //lineAmount = lineAmount - 1;
        String lineInfo = ".";
        String[] exportedData = new String[lineAmount];
        Scanner lineReader = new Scanner (file);
        for (int i = 0; i < lineAmount; i++) {
            lineInfo = lineReader.nextLine();
            exportedData[i] = lineInfo;
        }
        return exportedData;
    }
    //saves everything in the file as a string array

    public void makeFile (String fileNameWithTxt) {
        File newUserFile = new File(fileNameWithTxt);


        try {
            FileWriter newUserFileWriter = new FileWriter(fileNameWithTxt);
            if (newUserFile.exists()) {
                System.out.println("Error: Account Already Made:");

            } else {
                newUserFile.createNewFile();
                System.out.println("File created");
                newUserFileWriter.write("userpass: " + fileNameWithTxt);
            }
        }   catch (IOException e) {
            System.out.println("IOException");
        }

    }
    //makes file once given file name

    /*
    public void ifmakeFile (String name) throws IOException{

        name = name + ".txt";
        File file = new File(name);

        if (file.exists()) {
            System.out.println("File already exists - " + file.getName());
        } else {
            file.createNewFile();
            System.out.println("File created");
        }
    }*/
}

