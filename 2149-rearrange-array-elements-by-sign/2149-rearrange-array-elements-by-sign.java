class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n  = nums.length;
      ArrayList<Integer> pos  = new ArrayList<>();
     ArrayList<Integer> neg = new ArrayList<>();
        
        int[] result = new int[n];
        for(int x:nums){
            if(x>0){
                    pos.add(x);
            }else{
                    neg.add(x);
            }
            
        }
        
        for(int i=0;i<pos.size();i++){
                result[i*2] = pos.get(i);
                result[(i*2)+1] = neg.get(i);
        }
        
        return result;
        
    }
}