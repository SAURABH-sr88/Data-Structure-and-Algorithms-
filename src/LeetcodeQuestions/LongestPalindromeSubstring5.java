package LeetcodeQuestions;

public class LongestPalindromeSubstring5 {
   public static String longPal(String s){
       if (s == null || s.isEmpty()) return s;

       int start = 0 , end = 0;
       for (int i = 0; i < s.length(); i++) {
           int len1 = expandAroundCentre(s, i, i);
           int len2 = expandAroundCentre(s, i, i + 1);

           int len = Math.max(len1, len2);

           if (len > end - start ){
               start  = i - (len - 1)/2;
               end = i + len / 2;
           }
       }
       return s.substring(start, end + 1);
   }
   private static int expandAroundCentre (String s, int left, int right){
       while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
           left --;
           right ++;
       }
       return right - left - 1;
   }
    public static void main(String[] args) {
        String s = "baabjhviycv";
        String string = longPal(s);
        System.out.println(string);
    }
}
