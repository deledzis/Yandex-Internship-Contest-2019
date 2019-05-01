package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input1.txt"));
            int n = scanner.nextInt();
            ArrayList<Integer> nums = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                nums.add(scanner.nextInt());
            }
            long sum = nums.stream().distinct().mapToLong(i -> i).sum();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}