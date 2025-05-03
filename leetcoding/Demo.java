package leetcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 1),
                Arrays.asList(5, 3),
                Arrays.asList(6, 4),
                Arrays.asList(10, 1)
        ));

        List<List<Integer>> list2 = new ArrayList<>(Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(6, 3),
                Arrays.asList(9, 2)
        ));
        List<List<Integer>> ans = Solution.merge(list1, list2);
        
        for(List<Integer> list : ans) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}