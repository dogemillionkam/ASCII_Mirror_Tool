package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String userPath = scanner.next();
        File file = new File(userPath);
        int longestIndex = 0;
        ArrayList<String> mirror = new ArrayList<>();
        try (Scanner scannerTwo = new Scanner(file)) {
            while (scannerTwo.hasNextLine()) {
                String line = scannerTwo.nextLine();
                longestIndex = Math.max(line.length(), longestIndex);
                mirror.add(line);

            }
            for (String s : mirror) {
                String modified = s + " ".repeat(longestIndex - s.length());
                String reverseModified = new StringBuilder(modified).reverse().toString();
                StringBuilder reverseModifiedTwo = new StringBuilder();
                for(int i = 0; i < reverseModified.length(); i++) {
                    switch (reverseModified.charAt(i)) {
                        case '[' -> reverseModifiedTwo.append("]");
                        case ']' -> reverseModifiedTwo.append("[");
                        case '{' -> reverseModifiedTwo.append("}");
                        case '}' -> reverseModifiedTwo.append("{");
                        case ')' -> reverseModifiedTwo.append("(");
                        case '(' -> reverseModifiedTwo.append(")");
                        case '/' -> reverseModifiedTwo.append("\\");
                        case '\\' -> reverseModifiedTwo.append("/");
                        case '>' -> reverseModifiedTwo.append("<");
                        case '<' -> reverseModifiedTwo.append(">");
                        default -> reverseModifiedTwo.append(reverseModified.charAt(i));
                    }
                }
                System.out.println(modified + " | " + reverseModifiedTwo);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found!");
        }
    }
}