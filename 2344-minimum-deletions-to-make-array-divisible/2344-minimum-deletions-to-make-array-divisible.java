class Solution {
    public int minOperations(int[] nums, int[] nd) {
        
        int gcd =  nd[0];
        
        for(int x : nd){
            gcd = gcd(gcd , x);
        }
        
        int count =0 ;
        Arrays.sort(nums);
        for(int x : nums){
            
            if(gcd%x==0)return count;
            count++;
        }
        
        return -1;
        
        
    }
    
    
    public int gcd(int a , int b){
        if(a==0)return b;
        
        return gcd(b%a , a);
    }
}