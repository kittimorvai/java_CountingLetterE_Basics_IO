package com.example.mypackage;
import java.io.*;
import java.util.Scanner;

//Oracle Java Tutorial
// Write an example that counts the number of times a particular character, such as e, appears in a file.
// The character can be specified at the command line. You can use xanadu.txt as the input file.

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("Please type in the letter you would like to count:");
        String letterToCount = scanner.nextLine();
        System.out.println("Counting...");

        File file = new File("C:\\Users\\Kitti\\Documents\\Java Masterclass\\CountingLetterE_IO\\xanadu.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("Failed to find file: " + file.getAbsolutePath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("xanadu.txt"))){
            StringBuilder text = new StringBuilder();
            String line = reader.readLine();

            while(line != null){
                text.append(line);
                line = reader.readLine();
            }
            String wholeText = text.toString();

            for (int i = 0; i < wholeText.length(); i++){
                char c = wholeText.charAt(i);
                String toBeFound = Character.toString(c);
                if(toBeFound.toLowerCase().equals(letterToCount)){
                    count++;
                }
            }
            System.out.println("There are " + count + " letters of " + letterToCount);

        } catch (IOException e){
            e.getStackTrace();
        }
   }
}
