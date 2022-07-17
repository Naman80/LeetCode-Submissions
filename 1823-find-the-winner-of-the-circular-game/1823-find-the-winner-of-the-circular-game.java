class Solution {
    public int findTheWinner(int n, int k) {
        
       return solve(n,k)+1;
        
    }
    
    int solve(int n , int k){
        if(n==0)return 1;
        int ans = solve(n-1,k);
        return (ans+k)%n ;
    }
}