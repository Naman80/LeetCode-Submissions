class Solution {
      public int lengthOfLongestSubstring(String s) {
       int len=0;
       int i = 0;int j = 0;int n = s.length();
       HashSet<Character> hm = new HashSet<>();
       while(j<n){
           char ch = s.charAt(j);
           while(hm.contains(ch)){
               hm.remove(s.charAt(i));
               i++;
           }
           hm.add(ch);
           len = Math.max(len,j-i+1);
           j++;
       }
       return len;
   }
    //     public int lengthOfLongestSubstring(String s) {
    //     int len=0;
    //     int i = 0;int j = 0;int n = s.length();
    //     int bits=0;
    //     while(j<n){
    //         int ch = s.charAt(j) - 'a';
    //         while((bits & (1<<ch)) != 0){  // checking bit on or off
    //             int ch1 = s.charAt(i) - 'a';
    //             bits = bits ^ (1<<ch1); // ch1'th bit turn off
    //             i++;
    //         }
    //         bits = bits | (1<<ch); // ch'th bit turn on
    //         len = Math.max(len,j-i+1);
    //         j++;
    //     }
    //     return len;
    // }
}