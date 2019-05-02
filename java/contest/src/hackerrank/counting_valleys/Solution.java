package hackerrank.counting_valleys;

public class Solution {
    static int countingValleys(int n, String s) {
        int valleys = 0;
        boolean insideValley = false;
        int altitude = 0;
        for (char c : s.toCharArray()) {
            if (c == 'U') altitude++;
            else altitude--;
            if (altitude < 0 && !insideValley) {
                insideValley = true;
            }
            if (altitude >= 0 && insideValley) {
                valleys++;
                insideValley = false;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
}