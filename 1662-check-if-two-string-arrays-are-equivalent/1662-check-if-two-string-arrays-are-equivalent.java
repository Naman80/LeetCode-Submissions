class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        
        for(String x : word1)sb.append(x);
        for(String y : word2)sb1.append(y);
        
        return String.valueOf(sb).equals(String.valueOf(sb1));
        
        
        }
}