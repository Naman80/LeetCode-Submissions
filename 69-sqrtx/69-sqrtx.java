class Solution {
    public int mySqrt(int x) {
        
        int i = 0;int j  = x;
        long mid = 0;
        while(i<=j){
            mid= i + (j-i)/2;
            if(mid*mid == x) return (int)mid;
            if(mid*mid > x) j = (int)mid-1;
            else i  =  (int) mid +1;
        }
        
        
       
        return i-1;
    }
}