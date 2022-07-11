// class Solution {
//     public int countSubstrings(String s) {
//        int n = s.length();
//         boolean[][] dp =  new boolean[n][n];
//         int count = 0;
//         for(int g = 0 ; g < n ; g++){
//             for(int i = 0 , j = g ; j < n ; i++,j++){
//                 if(i==j){
//                     dp[i][j] = true;
//                     count++;
//                 }else if(Math.abs(i-j)==1){
//                        if(s.charAt(i) == s.charAt(j)){
//                            dp[i][j] = true;
//                            count++;
//                        }
//                 }
//                 else{
//                     if(s.charAt(i) == s.charAt(j)){
//                         if(dp[i+1][j-1]){
//                             dp[i][j] = true;
//                             count++;
//                         }
//                     }   
//                 }
//             }   
//         }
//         return count;
//     }
// }


public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}