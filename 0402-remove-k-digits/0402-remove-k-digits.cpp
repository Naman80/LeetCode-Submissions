class Solution {
public:
    string removeKdigits(string s, int k) {
         int n = s.length();
       stack<char> st;
       for(int i =  0 ; i < n ;i++){
            while(st.size()>0 && st.top() > s[i] && k>0){
                st.pop();
                k--;
            }
            st.push(s[i]);
       }
       while(k--){
           st.pop();
       }
       string ans = "";
       while(st.size()){
           char ch = st.top();
           st.pop();
           ans+=ch;
       }
        reverse(ans.begin() , ans.end());
       int len = ans.length();
       int i =0 ;
       while(i < len && ans[i]=='0')i++;
       string temp = ans.substr(i);
       return i==len ? "0" :  temp;
    }
};