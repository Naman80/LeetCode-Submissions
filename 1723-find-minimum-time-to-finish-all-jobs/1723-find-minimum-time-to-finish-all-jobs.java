class Solution {
    int min = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] persons = new int[k];    
        solve(jobs.length-1,k,jobs,persons);  
        return min;
    }
   void solve(int start,int k,int[] jobs,int[] persons){
        int max = getMax(persons);
        // if(max>=min)return;
        if(start<0){
            min = Math.min(min,max);
            return;
        }
        for(int i = 0 ; i < k ; i++){
            if(i>0 && persons[i-1]==persons[i])continue;
            persons[i]+= jobs[start];
            solve(start-1,k,jobs,persons);
            persons[i]-= jobs[start];   
        }
    }
    int getMax(int[] persons){   
        int max = Integer.MIN_VALUE;
        for(int x : persons){
            max = Math.max(max,x);
        }
        return max;
    }
}