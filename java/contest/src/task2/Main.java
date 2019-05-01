package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input2.txt"));
            String inp = scanner.next();
            long sum = 0;
            for (int i = 0; i < inp.length(); i++) {
                char c = inp.charAt(i);
                if (Character.isAlphabetic(c)) {
                    if (i == inp.length() - 1) {
                        sum++;
                        break;
                    }
                    if (!Character.isDigit(inp.charAt(i + 1))) {
                        sum++;
                    }
                }
                else if (Character.isDigit(c)) {
                    StringBuilder sb = new StringBuilder();
                    while (Character.isDigit(c)) {
                        sb.append(c);
                        i++;
                        if (i >= inp.length()) break;
                        c = inp.charAt(i);
                    }
                    i--;
                    sum += Integer.valueOf(sb.toString());
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}