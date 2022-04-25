class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> al = new ArrayList<>();
        
        int i = 0;int j = nums.length-1;
        int mid = 0;
        while(i<=j){
             mid = i + (j-i)/2;
            if(nums[mid]==target) {
                al.add(mid);
                break;
            }
            if(nums[mid] > target){
                j = mid -1;
                
            }else i = mid+1;
        }
        
        if(al.size()==0) return al;
        i = mid-1;j=mid+1;
        while(i>=0 && nums[i] == target) al.add(0,i--);
        while(j<=nums.length-1 && nums[j] == target) al.add(j++);
        return al;
    }
}