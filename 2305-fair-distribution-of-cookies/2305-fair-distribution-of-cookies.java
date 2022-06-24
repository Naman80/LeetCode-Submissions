class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cook, int k) {
        
    int[] arr = new int[k];    
        solve(0,cook,arr,k);
    return ans;
    }
    
    
    public void solve(int idx , int[] cook , int[] arr , int k){
        
        if(idx>=cook.length){
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i<k;i++){
                if(arr[i]==0)return;
                max = Math.max(max,arr[i]);
            }
            ans= Math.min(ans,max);
            return;
        }   
        for(int i =0;i<k;i++){
            if(i>0 && arr[i-1]==0)break;
            arr[i]+=cook[idx];
            solve(idx+1,cook,arr,k);
            arr[i]-=cook[idx];
        }
    }
}