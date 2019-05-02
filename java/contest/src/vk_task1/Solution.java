package vk_task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    static boolean checkIsAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] s1Chars = s1.toCharArray();
            char[] s2Chars = s2.toCharArray();
            Arrays.sort(s1Chars);
            Arrays.sort(s2Chars);
            for (int i = 0; i < s1Chars.length; i++) {
                if (s1Chars[i] != s2Chars[i]) return false;
            }
        }
        return true;
    }

    static List<String> funWithAnagrams(List<String> s) {
        // Write your code here
        List<String> res = new ArrayList<>(s.size());
        res.add(s.get(0));
        for (int i = 1; i < s.size(); i++) {
            String comparable = s.get(i);
            boolean toBeAdded = true;
            for (int j = 0; j < i; j++) {
                if (checkIsAnagram(comparable, s.get(j))) {
                    toBeAdded = false;
                    break;
                }
            }
            if (toBeAdded) res.add(comparable);
        }
        Collections.sort(res);
        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.funWithAnagrams(s);

        bufferedWriter.write(
                String.join("\n", result)
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
