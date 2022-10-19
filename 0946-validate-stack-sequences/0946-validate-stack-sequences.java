class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0 ;
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while(i < n  && j < n){
            
            while(st.size()!=0 && st.peek() ==  popped[j]){
                st.pop();
                j++;
            }
            
            st.push(pushed[i]);
            i++;
            
        }
        
            while(st.size()!=0 && st.peek() ==  popped[j]){
                st.pop();
                j++;
            }
        
        return st.isEmpty();        
    }
}