package hackerrank.sock_merchant;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socks = new HashMap<>();
        for (int c : ar) {
            if (!socks.containsKey(c)) {
                socks.put(c, 1);
            } else {
                socks.replace(c, socks.get(c) + 1);
            }
        }
        int pairs = 0;
        for (int color : socks.values()) {
            pairs += color / 2;
        }
        System.out.println(pairs);
        return pairs;
    }

    public static void main(String[] args) {
        sockMerchant(7, new int[] { 1, 2, 1, 2, 1, 3, 2 });
    }
}

