class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        
        while(n!=1 && !set.contains(n)){
            int ans = solve(n);
            set.add(n);
            n = ans;
        }
        
        if(n==1)return true;
        return false;
        
    }
    
    public int solve(int n){
        
        int sum = 0;
        while(n>0){
            int last = n%10;
            sum += (last * last);
            n = n/10;
        }
        
        return sum;
        
        
    }
    
    
}