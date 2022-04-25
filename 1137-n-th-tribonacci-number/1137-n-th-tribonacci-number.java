class Solution {
    public int tribonacci(int n) {
        if(n==0)return 0;
        int pb = 0;int p = 1;int c = 1;
        n = n-2;
        while(n>0){
            int d = c;
            c = c+p+pb;
            pb = p;
            p = d;
            n--;
        }
        
        return c;
    }
}