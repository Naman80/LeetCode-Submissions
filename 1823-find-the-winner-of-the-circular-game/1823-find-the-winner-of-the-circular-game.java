class Solution {
    public int findTheWinner(int n, int k) {
        
       // return solve(n,k)+1;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 1;i<=n;i++){
            deque.addLast(i);
        }
        while(deque.size()>1){
            for(int j = 1 ; j < k ; j++){
                int in = deque.pollFirst();
                deque.addLast(in);
            }
            deque.pollFirst();
        }
        return deque.pollFirst();
    }
    
//     int solve(int n , int k){
//         if(n==0)return 1;
//         int ans = solve(n-1,k);
//         return (ans+k)%n ;
//     }
}