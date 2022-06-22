class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        for(int x : nums){
            pq.add(x);
        }
        
        k--;
        
        while(k-- > 0){
            pq.poll();
        }
        
        return pq.poll();
    
        
    }
}