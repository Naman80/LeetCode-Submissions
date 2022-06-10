class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        int i = 0;int j = 0;int n = s.length();
        HashMap<Character , Integer> hm = new HashMap<>();
        while(j<n){
            
            char ch = s.charAt(j);
            while(hm.containsKey(ch)){
                hm.remove(s.charAt(i));
                i++;
            }
                hm.put(ch,1);
            len = Math.max(len,j-i+1);
                j++;
            
        }
        
        return len;
    }
}