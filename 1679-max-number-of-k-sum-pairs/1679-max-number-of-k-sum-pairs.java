// class Solution {
//     public int maxOperations(int[] nums, int k) {
//      HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int c:nums){
//             if(!hm.containsKey(c)){
//                 hm.putIfAbsent(c,1);
//             }else{
//                 hm.put(c,hm.get(c)+1);
//             }
//         }
//         int ans = 0;
//         for(int x:nums){
//             if(hm.get(x)==0)continue;
//             if(k-x>0){
//             int diff = k - x;
//             hm.put(x,hm.get(x)-1);
//             if(hm.containsKey(diff) && hm.get(diff)>0){
//                 ans++;
//                 hm.put(diff,hm.get(diff)-1);
//             }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            //to check if that k-nums[i] present and had some value left or already paired
            if(map.containsKey(k-nums[i])&&map.get(k-nums[i])>0){
                count++;
                map.put(k-nums[i],map.get(k-nums[i])-1);
            }else{
                //getOrDefault is easy way it directly checks if value is 0 returns 0 where I added 1
                //and if some value is present then it return that value "similar to map.get(i)" and I added 1 on it 
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}