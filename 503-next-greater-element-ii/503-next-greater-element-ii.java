class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[2*n];
        
        for(int i = 0 ; i < 2*n ; i++){
            nums2[i] = nums[i%n];
        }
        
        nums2 = solve(nums2);
        
        int[] arr = new int[n];
        
        for(int i = 0 ;i<n;i++){
            arr[i] = nums2[i];
        }
        
        return arr;
    }
    
    int[] solve(int[] arr){

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        
        for(int i= n-2 ; i >=0 ;i--){
            
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();    
            }
            
            if(st.size()!=0){
                
                ans[i] = st.peek();
                
            }
            
            st.push(arr[i]);
            
            
            
            
        }
        
        
        return ans;
    
    }
    
    
    
}