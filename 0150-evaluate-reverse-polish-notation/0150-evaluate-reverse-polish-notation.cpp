class Solution {
public:
    int evalRPN(vector<string>& tokens) {
         stack<int>st;
        
        
        for(int i = 0 ; i < tokens.size();i++){
            if(tokens[i][0] == '*'){
                int o1 = st.top();
                st.pop();
                int o2 = st.top();
                st.pop();
                st.push(o2*o1);
            }else if(tokens[i][0] == '/'){
             int o1 = st.top();
                st.pop();
                int o2 = st.top();
                st.pop();
                st.push(o2/o1);
            }else if(tokens[i][0] == '+'){
                int o1 = st.top();
                st.pop();
                int o2 = st.top();
                st.pop();
                st.push(o2+o1);
            }else if(tokens[i][0] == '-' && tokens[i].size() == 1){
                int o1 = st.top();
                st.pop();
                int o2 = st.top();
                st.pop();
                st.push(o2-o1);
            }else{
                int in = stoi(tokens[i]);
                st.push(in);
            }
            
        }
        
        return st.top();
    }
};