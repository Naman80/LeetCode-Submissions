class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        int[] use = nge(temp);
          int n = temp.length;
        for(int  i = 0 ; i < n ; i++){
            if(use[i] == 0)continue;
            
            else use[i] = use[i]  - i;
        }
        
        return use;
        
    }
    
    public int[] nge(int[] temp){
        
        
        int n = temp.length;
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];
        st.push(n-1);
        // Arr
        // arr[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            
            
            while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                st.pop();
            }
            if(st.size()!=0){
                  arr[i] = st.peek();
            }
            
            st.push(i);
          
            
        }
        
        return arr;
        
    }
    
}