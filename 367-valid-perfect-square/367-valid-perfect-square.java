class Solution {
    public boolean isPerfectSquare(int num) {
        int i  = 0;
        int j = num;
        long mid = 0;
        while(i<=j){
            mid = i + (j-i)/2;
            if(mid*mid == num) return true;
            if(mid*mid > num) j = (int)mid-1;
            else i = (int)mid+1;
        }
        return false;
    }
}