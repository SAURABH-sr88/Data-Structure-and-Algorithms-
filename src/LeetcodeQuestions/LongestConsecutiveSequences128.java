package LeetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequences128 {
    public static int LCS(int[] arr){
        Set<Integer> numSet = new HashSet<>();

        for (int num : arr){
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet){
            if (!numSet.contains(num-1)) {
                int currentStreak = 1;
                int currentNumber = num;
                while (numSet.contains(currentNumber + 1)){
                    currentStreak += 1;
                    currentNumber += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,45,23,69};
        int lcs = LCS(arr);
        System.out.println(lcs);
    }
}
