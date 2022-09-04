class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n  = nums.length;
        
        int i = 0 ; 
        int j = 0;
        int[] bits = new int[32];
        int ans = 1;
        
        while(j < n){
            for(int k = 0 ; k < 32 ; k++){
                int shift = (1 << k);
                if((nums[j] & shift) != 0){
                    ans = Math.max(ans , j - i);
                    while(bits[k]!=0){
                        for(int l = 0 ; l < 32 ; l++){
                            if((nums[i] & (1 << l))!=0) bits[l]--;
                        }
                        i++;
                    }
                    bits[k]++;
                }
            }
            j++;
        }
        ans = Math.max(ans , j - i);
        return ans;
    }
}