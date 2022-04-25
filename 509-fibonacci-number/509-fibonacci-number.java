class Solution {
    public int fib(int n) {
          if(n==0 || n==1){
            return n;
        }
        int p = 0;
        int c = 1;
        for(int i = 2;i<=n;i++){
            int d = c;
            c+=p;
            p=d;
        }
        return c; 
    }
}