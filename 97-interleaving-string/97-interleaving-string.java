class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        // dp[i][j] will store whether it is possible to make string S3 uptill
        // i+j-1 character by using i characters of S1 and j characters of S2
        
        // S1 will make row characters of dp
        // s2 will make col character of dp
        
        // TABULATION SOLUTION
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        
        if(l1+l2 != l3)return false;
        
//         boolean[][] dp = new boolean[l1+1][l2+1];
//         dp[0][0] = true; // if all three strings are empty then it is always possible
        
//         for(int i = 0 ; i< l1+1;i++){
//             for(int j = 0 ; j < l2+1;j++){
//                 if(i==0 || j==0){
//                     if(i>0 && j==0){
//                         if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][j]){
//                             dp[i][j] = dp[i-1][j];
//                         }
//                     }
//                     if(j>0 && i==0){   
//                         if(s2.charAt(j-1) == s3.charAt(j-1) && dp[i][j-1]){
//                             dp[i][j] = dp[i][j-1];
//                         }
//                     }  
//                 }
//                 else{
//                     char ch1 = s1.charAt(i-1);
//                     char ch2 = s2.charAt(j-1);
//                     char ch3 = s3.charAt(i+j-1);
//                     if(ch1 == ch3 && dp[i-1][j]){  
//                         // if s1[i-1] ==  s3[i+j-1]  --> 
//                         // if character match form s1 check is it possible 
//                         // to make (s3) after removing that character
//                         // to remove that character we will check from upper row
//                         // if it is true then mark true;
//                         dp[i][j] = dp[i-1][j];
//                     }
                    
                    
//                     if(ch2==ch3 && dp[i][j-1]){
                        
                        
//                         // if s2[j-1] ==  s3[i+j-1]  --> 
//                         // if character match form s2 check is it possible 
//                         // to make (s3) after removing that character
//                         // to remove that character we will check from prev col
//                         // if it is true then mark true;
                        
//                         dp[i][j] = dp[i][j-1];
//                     }
                    
                    
//                 }
//             }
//         }
//         return dp[l1][l2];     
        
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        
        return solve(s1,s2,s3,0,0,dp);
    }
    
    // RECURSION + MEMO
    
    
    boolean solve(String s1, String s2, String s3 , int i , int j,Boolean[][] dp){
        
        if(i == s1.length() && j == s2.length())return true;
        if(dp[i][j]!=null)return dp[i][j];
        
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            boolean s1match = dp[i][j] = solve(s1,s2,s3,i+1,j,dp);
            if(s1match)return true;
        }
        
        
        if(j < s2.length()  && s2.charAt(j) == s3.charAt(i+j)){
            boolean s2match = dp[i][j] =  solve(s1,s2,s3,i,j+1,dp);
            if(s2match)return true;
        }
        
        
        return dp[i][j] = false;
        
        
    }
    
    
}