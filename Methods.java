import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class Methods {

    public boolean findUser (String x) throws IOException {
        Scanner loginFinder = null;
        try {
            loginFinder = new Scanner(new FileInputStream("LoginDetails.txt"));
            while (loginFinder.hasNextLine()) {
                String loginDetails = loginFinder.nextLine();
                if (x.equals(loginDetails)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } finally {
            loginFinder.close();
        }
        return Files.readAllLines(Path.of("LoginDetails.txt")).contains(x);
    }

    //public String tokenFinder(String x, String y, String z) {

    //}
    public boolean addToDoc (String x, String y) {
        PrintWriter xWriter = null;
        boolean result = true;
        try {
            xWriter = new PrintWriter(x);
            xWriter.print(y);
            return true;
        }catch (IOException e) {
            System.out.print("IOException");
            return false;

        }

    }
    public int findAmountOfLines (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        int lineAmount= 0;
        Scanner lineCounter = new Scanner(file);
        while(lineCounter.hasNextLine()) {
            lineCounter.nextLine();
            lineAmount++;
        }
        return lineAmount;
    }

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

    public String[] saveData (int lineAmount, String fileName) throws FileNotFoundException{
        File file = new File(fileName);
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

    public void makeFile (String userpass) {
        String userpassFile = (userpass + ".txt");
        File newUserFile = new File(userpassFile);
        try {
            if (newUserFile.exists()) {
                System.out.println("Error: Account Already Made");

            } else {
                newUserFile.createNewFile();
                System.out.println("File created");

            }
        }   catch (IOException e) {
            System.out.println("IOException");
        }

    }
    public void ifmakeFile (String name) throws IOException{
        name = name + ".txt";
        File file = new File(name);

        if (file.exists()) {
            System.out.println("File already exists - " + file.getName());
        } else {
            file.createNewFile();
            System.out.println("File created");
        }
    }
}

