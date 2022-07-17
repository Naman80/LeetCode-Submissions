class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
     
        int qn = q.length;
        int[] ans = new int[qn];
        int n = nums.length;
        for(int j = 0 ;  j< qn ; j++){
            int k = q[j][0];
            int trim = q[j][1];
            Pair[] pass = new Pair[n];
            for(int i = 0 ; i < n; i++){
                int slen = nums[i].length();
                String temp = nums[i].substring(slen - trim);
                pass[i] = new Pair(temp,i);
            }
            ans[j] = solveans(pass , k);   
        }
        return ans;   
    }
    int solveans(Pair[] nums , int k){
        Arrays.sort(nums);
        return nums[k-1].idx;
    }
}


class Pair implements Comparable<Pair>{
    String num ; int idx;
    Pair(String num , int idx){
        this.num = num;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Pair o) {
        return this.num.compareTo(o.num);
    }
}