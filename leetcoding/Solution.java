package leetcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> merge(List<List<Integer>> input1, List<List<Integer>> input2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < input1.size() || j < input2.size()) {
            if (i < input1.size() && j < input2.size()) {
                List<Integer> a = input1.get(i);
                List<Integer> b = input2.get(j);
                if (a.get(0) == b.get(0)) {
                    res.add(Arrays.asList(a.get(0), a.get(1) + b.get(1)));
                    i++;
                    j++;
                } else if (a.get(0) < b.get(0)) {
                    res.add(Arrays.asList(a.get(0), a.get(1) + b.get(1)));
                    i++;
                } else if (a.get(0) > b.get(0)) {
                    res.add(Arrays.asList(b.get(0), a.get(1) + b.get(1)));
                    j++;
                }
            } else if (j >= input2.size()) {
                res.add(input1.get(i));
                i++;
            } else {
                res.add(input2.get(j));
                j++;
            }
        }
        return res;
    }
}

/*
    Follow Ups:
    1. What if the data was coming in as a stream? 
    2. What if we had more than 2 lists?
 */