class Solution {
    public int findMin(int[] nums) {
        
        int min =6000;
        for(int x:nums)min = Math.min(min , x);
        return min;
        
    }
    
}