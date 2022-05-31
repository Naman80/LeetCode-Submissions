class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs =  new HashSet<>();
        int n = s.length();
        
        int i = 0;int j = i + k - 1;
        
        if(j>=n)return false;
        
        while(j<n){
            hs.add(s.substring(i,j+1));
            i++;j++;
        }
        return (hs.size() == (1<<(k)));
    }
}