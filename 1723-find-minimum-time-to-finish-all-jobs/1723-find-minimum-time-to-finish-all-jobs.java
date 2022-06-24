class Solution {
    int ans = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] persons = new int[k];    
        solve(0,jobs,persons,k);  
        return ans;
    }
   // void solve(int start,int k,int[] jobs,int[] persons){
   //      int max = getMax(persons);
   //      if(max>=min)return;
   //      if(start<0){
   //          min = Math.min(min,max);
   //          return;
   //      }
   //      for(int i = 0 ; i < k ; i++){
   //          if(i>0 && persons[i-1]==0)break;
   //          persons[i]+= jobs[start];
   //          solve(start-1,k,jobs,persons);
   //          persons[i]-= jobs[start];   
   //      }
   //  }
    int getMax(int[] persons){   
        int max = Integer.MIN_VALUE;
        for(int x : persons){
            max = Math.max(max,x);
        }
        return max;
    }
    
    public void solve(int idx , int[] cook , int[] arr , int k){
        // if(idx>=cook.length){
        //     int max = Integer.MIN_VALUE;
        //     for(int i = 0 ; i<k;i++){
        //         if(arr[i]==0)return;
        //         max = Math.max(max,arr[i]);
        //     }
        //     ans= Math.min(ans,max);
        //     return;
        // }   
        int max = getMax(arr);
        if(max>=ans)return;
        if(idx>=cook.length){
            ans = Math.min(ans,max);
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