class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0 ; i<n;i++){
            String temp = solve(i,s);
            if(temp.length() > ans.length())ans = temp;
        }
        return ans;
    }
    
    String solve(int i , String str){
        int max = 1;
        int s = i-1;
        int e = i + 1;
        int n = str.length();
        String ret = "";
        while(s>=0 && e < n){
            char chs = str.charAt(s);
            char che = str.charAt(e);
            if(chs==che){
                s--;
                e++;
            }else{
                break;
            }    
        }
        max = e - s - 1;
        ret = str.substring(s+1 , e);
        s = i;
        e = i + 1;
        while(s>=0 && e < n){
            char chs = str.charAt(s);
            char che = str.charAt(e);
            if(chs==che){
                s--;
                e++;
            }else{
                break;
            }    
        }
        int emax = e - s - 1;
        if(emax>max){
             ret = str.substring(s+1 , e);
        }
        return ret;
    }
}