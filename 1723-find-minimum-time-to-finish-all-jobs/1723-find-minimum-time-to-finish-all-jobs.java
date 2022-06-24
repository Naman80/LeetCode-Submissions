class Solution {
    
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] persons = new int[k];    
        return solve(0,k,jobs,persons);  
    }
   int solve(int start,int k,int[] jobs,int[] persons){
        if(start>=jobs.length){
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < k;i++){
                max = Math.max(max,persons[i]);
            }
            return max;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < k ; i++){
            if(i>0 && persons[i-1]==0)break;
            persons[i]+= jobs[start];
            int temp = solve(start+1,k,jobs,persons);
            persons[i]-= jobs[start];
            ans = Math.min(temp,ans);
        }
        return ans;
    }
}