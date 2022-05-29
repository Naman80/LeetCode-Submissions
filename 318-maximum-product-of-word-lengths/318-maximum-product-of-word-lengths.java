class Solution {
    public int maxProduct(String[] w) {
        
        int n = w.length;
        int[] bits = new int[n];
        for(int i = 0;i<n;i++){
            String o = w[i];
            int ol = o.length();
            
            for(int j = 0;j<ol;j++){
                  bits[i] |= (1 << (o.charAt(j) - 'a'));
            }
         
        }
        
         int max =0;
            for(int i = 0;i<n-1;i++){
                for(int j = i+1;j<n;j++){
                    if((bits[i] & bits[j]) == 0){
                        max = Math.max(max , w[i].length() * w[j].length());
                    }
                }
            }
            
            return max;
    }
}