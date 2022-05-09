class Solution {
    public int largestRectangleArea(int[] h) {
        
        int n = h.length;
      
        Stack<Integer> st = new Stack<>();
        
        int[] rse = new int[n];
        
        st.push(0);
        rse[n-1]  = n;
        for(int i = 1;i<n;i++){
            while(!st.isEmpty() && h[st.peek()] > h[i]){
                rse[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            rse[st.pop()] = n;
        }
        int[] lse = new int[n];
        
        st.push(n-1);
        lse[0] = -1;
        for(int i = n-2;i>=0;i--){
         while(!st.isEmpty() && h[st.peek()] > h[i]){
                lse[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            lse[st.pop()] = -1;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            
            int ret  = h[i] * (rse[i] -lse[i] - 1);
            ans = Math.max(ret,ans);
        }
        
        return ans;
        
        
    }
    
//     public int solve(int val ,int[] h){
        
//         int i = val - 1;
//         int j = val + 1;
        
//         while(i>=0 && h[i] >= h[val]) i--;
        
//         while(j<h.length && h[j] >= h[val]) j++;
        
//         int ret  = h[val] * (j - i - 1);
        
//         return ret;
//     }
}