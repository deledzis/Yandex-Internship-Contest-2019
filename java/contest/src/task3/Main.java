package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> numsOld;
    private static ArrayList<Integer> nums;

    private static boolean isEven(int a) { return a % 2 == 0; }
    private static boolean isOdd(int a) { return a % 2 == 1; }
    private static boolean sameParity(int a, int b) { return (isEven(a) && isEven(b)) || (isOdd(a) && isOdd(b)); }
    private static void swapElements(int i1, int i2) {
        Integer a = nums.get(i1);
        nums.set(i1, nums.get(i2));
        nums.set(i2, a);
    }
    private static void printList() {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static int calculatePermitations() {
        int diffs = 0;
        for (int i = 0; i < numsOld.size(); i++) {
            if (!nums.get(i).equals(numsOld.get(i))) diffs++;
        }

        return diffs;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input3.txt"));
            int n = scanner.nextInt();
            nums = new ArrayList<>(n);
            int permutations = 0;
            for (int i = 0; i < n ; i++) {
                nums.add(scanner.nextInt());
            }
            numsOld = new ArrayList<>(nums);
            for (int i = 1; i < n; i++) {
                int cur = nums.get(i);
                if (sameParity(nums.get(i), nums.get(i - 1))) {
                    int j = i + 1;
                    if (j == n) {
                        if (!sameParity(cur, nums.get(0))) {
                            nums.add(0, nums.get(i));
                            nums.remove(nums.size() - 1);
                            break;
                        }
                        permutations = -1;
                        break;
                    }
                    boolean canBeSwapped = true;
                    while (sameParity(cur, nums.get(j))) {
                        j++;
                        if (j == n) {
                            permutations = -1;
                            canBeSwapped = false;
                            break;
                        }
                    }
                    if (!canBeSwapped) break;
                    swapElements(i, j);
                }
            }
            if (permutations > -1) {
                permutations = calculatePermitations();
                System.out.println(permutations);
                printList();
            } else System.out.println(-1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}