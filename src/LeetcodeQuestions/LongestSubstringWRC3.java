package LeetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWRC3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character is already in the set, remove from left
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String string = "ydg7ywf";
        int len = lengthOfLongestSubstring(string);
        System.out.println(len);
    }

}
