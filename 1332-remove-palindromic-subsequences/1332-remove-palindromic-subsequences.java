class Solution {
    public boolean isPalind(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int removePalindromeSub(String s) {
        if(isPalind(s)){
            return 1;
        }
        return 2;
    }}
