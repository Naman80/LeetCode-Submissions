class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i = 0 ;i < ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            map[ch - 'a']++;
        }
        for(int i = 0 ; i < magazine.length();i++){
            char ch = magazine.charAt(i);
            map[ch - 'a']--;
        }
        for(int i = 0 ; i < 26 ;i++){
            if(map[i]>0)return false;
        }
        
        return true;
    }
}