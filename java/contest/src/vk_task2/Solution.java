package vk_task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int goodSegment(List<Integer> badNumbers, int l, int r) {
        final int start = l;
        badNumbers.removeIf(i -> i < start || i > r);
        if (!badNumbers.contains(l)) badNumbers.add(l);
        if (!badNumbers.contains(r)) badNumbers.add(r);
        Collections.sort(badNumbers);
        System.out.println(Arrays.toString(badNumbers.toArray()));
        int max = badNumbers.get(1) - badNumbers.get(0);
        if (badNumbers.size() > 2) {
            for (int i = 2; i < badNumbers.size(); i++) {
                int res = badNumbers.get(i) - badNumbers.get(i - 1);
                if (badNumbers.get(i) != l && badNumbers.get(i) != r) res--;
                if (res > max) max = res;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> bad = new ArrayList<>(7);
        bad.add(48);
        bad.add(14);
        bad.add(33);
        bad.add(11);
        bad.add(17);
        bad.add(50);
        bad.add(25);
        System.out.println(goodSegment(bad, 12, 38));
    }
}
