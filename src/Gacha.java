import java.util.Arrays;
import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Gacha {

    public Gacha() {

    }

    public static void main(String[] args) {
        FileWriter myWriter;
        int pity = 0;
        int pity2 = 0;
        int roll = 0;
        int[] gacha = new int[10];
        String filepity;
        File file = new File("Counter.txt");
        System.out.println();
        try {
            //myWriter = new FileWriter("Counter.txt");
            //Scanner Reader = new Scanner(file);
            if (file.exists()) {
                System.out.println("File already exists - " + file.getName());

            } else {
                //file.createNewFile();
                myWriter = new FileWriter("Counter.txt");
                myWriter.write("0");
                myWriter.close();
                System.out.print("File created");

            }
            Scanner reader = new Scanner(file);
            try {
                filepity = reader.nextLine();
                pity = Integer.parseInt(filepity);
            }
            catch (NoSuchElementException e) {
                //myWriter.write(filepity);
                int s = 0;
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        for (int i = 0; i < 10; i++) {
            if (pity < 75) {
                System.out.print("A");
                roll = (int) ((double) Math.random() * 101);
                gacha[i] = roll;
                if (roll == 69) {
                    pity = 0;
                } else {
                    pity = pity + 1;
                }

            } else if (pity < 90) {
                System.out.print("B");
                roll = (int) ((double) Math.random() * 101);
                gacha[i] = roll;
                if (roll % ((-0.5 * pity) + 46.5) == 0) {
                    pity = 0;
                    System.out.println("\n5STAR!! - -" + pity);
                }else {
                    pity = pity + 1;
                }


            } else if (pity == 90) {
                System.out.print("C");
                roll = (int) ((double) Math.random() * 101);
                gacha[i] = roll;
                pity = 0;
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(gacha));
        System.out.println(pity);


        try {
            myWriter = new FileWriter("Counter.txt");
            filepity = String.valueOf(pity);
            myWriter.write(filepity);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}