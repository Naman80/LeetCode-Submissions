class Solution {
    public int countSubstrings(String s) {
       int n = s.length();
        int sum = 0;
        for(int i = 0;i<n;i++){
          for(int j = i;j<n;j++){
              if(isPal(s.substring(i,j+1)))sum++;
          }
        }
        return sum;
    }
    boolean isPal(String s){
        int i =0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}