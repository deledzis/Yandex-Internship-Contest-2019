package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> nums;

    private static boolean isEven(int a) { return a % 2 == 0; }
    private static boolean isOdd(int a) { return a % 2 == 1; }
    private static boolean sameParity(int a, int b) { return (isEven(a) && isEven(b)) || (isOdd(a) && isOdd(b)); }
    private static void swapElements(int i1, int i2) {
        Integer a = nums.get(i1);
        nums.set(i1, nums.get(i2));
        nums.set(i2, a);
    }


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input3.txt"));
            int n = scanner.nextInt();
            nums = new ArrayList<>(n);
            int permutations = 0;
            for (int i = 0; i < n ; i++) {
                nums.add(scanner.nextInt());
                System.out.print(nums.get(i) + " ");
            }
            for (int i = 1; i < n; i++) {
                int cur = nums.get(i);
                if (sameParity(nums.get(i), nums.get(i - 1))) {
                    int j = i + 1;
                    if (j == n) {
                        permutations = -1;
                        break;
                    }
                    while (sameParity(cur, nums.get(j))) {
                        j++;
                        if (j == n) {
                            permutations = -1;
                            break;
                        }
                    }
                    swapElements(i, j);
                    permutations++;
                }
            }
            System.out.println(permutations);
            if (permutations > -1) {
                for (int i : nums) {
                    System.out.print(i + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}