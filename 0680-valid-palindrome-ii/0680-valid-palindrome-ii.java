class Solution {
    public boolean validPalindrome(String s) {
        
        int n = s.length();
        int i = 0 ;
        int j = n-1;
        int count =0;
        while(i<=j){
            char f = s.charAt(i);
            char l = s.charAt(j);
            if(f!=l){
                count = 1;
                break;
            }
            i++;
            j--;
        }
        // if(count==0)return true;
        int iplus = i+1;
        int jminus = j-1;
        
        while(iplus <= j){
            char f = s.charAt(iplus);
            char l = s.charAt(j);
            if(f!=l){
                count++;
                break;
            }
            iplus++;
            j--;
        }
        if(count==1)return true;
        count=1;
        while(i <= jminus){
            char f = s.charAt(i);
            char l = s.charAt(jminus);
            if(f!=l){
                count++;
                break;
            }
            i++;
            jminus--;
        }
        return count<=1;
        
    }
}



// adbsdvdsebda
// aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga