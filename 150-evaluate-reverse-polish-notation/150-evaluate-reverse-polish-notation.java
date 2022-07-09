class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        
        for(int i = 0 ; i < tokens.length;i++){
            
            
            if(tokens[i].charAt(0) == '*'){
                int o1 = st.pop();
                int o2 = st.pop();
                st.push(o2*o1);
            }else if(tokens[i].charAt(0) == '/'){
                int o1 = st.pop();
                int o2 = st.pop();
                st.push(o2/o1);
            }else if(tokens[i].charAt(0) == '+'){
                int o1 = st.pop();
                int o2 = st.pop();
                st.push(o2+o1);
            }else if(tokens[i].charAt(0) == '-' && tokens[i].length() == 1){
                int o1 = st.pop();
                int o2 = st.pop();
                st.push(o2-o1);
                
            }else{
                int in = Integer.parseInt(tokens[i]);
                st.push(in);
            }
            
        }
        
        return st.pop();
    }
}