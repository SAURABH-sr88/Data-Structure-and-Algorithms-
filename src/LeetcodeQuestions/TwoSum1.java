package LeetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static int[] twoSum(int[] num, int target){
        Map<Integer, Integer> numSet = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int temp = target - num[i];
            if (numSet.containsKey(temp)){
                return new int[]{numSet.get(temp), i};
            }
            numSet.put(num[i], i);
        }
        throw new IllegalArgumentException("No two sum found");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }
}
