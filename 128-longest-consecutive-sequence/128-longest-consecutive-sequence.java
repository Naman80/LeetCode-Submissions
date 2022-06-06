class Solution {
    public int longestConsecutive(int[] nums) {
        //O(nlogn) solution
        
        // if(nums.length == 0 )return 0;
        // Arrays.sort(nums);
        // int ans = 0;
        // int temp = 1;
        // for(int i = 1 ; i < nums.length;i++){
        //     if(nums[i] == nums[i-1])continue;
        //     if(nums[i-1] +1 == nums[i]){
        //         temp++;
        //     }else{
        //         ans = Math.max(ans,temp);
        //         temp = 1;
        //     }
        // }
        // ans = Math.max(ans,temp);
        // return ans;
        
        // O(n) solution + O(n) Space solution
        
        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums)hs.add(x);
        int max = 0;
        for(int x : nums){
            if(!hs.contains(x-1)){
                int currele = x;
                int curmax = 1;
                while(hs.contains(currele+1)){
                    currele+=1;
                    curmax+=1;
                }
                max = Math.max(max,curmax);   
            }   
        }
        return max;
    }
}