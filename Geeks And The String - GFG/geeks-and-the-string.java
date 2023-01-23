//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
    Stack<Character> st = new Stack<>();
    
    int n = s.length();
    for(int i = 0 ; i < n ; i ++){
        char ch = s.charAt(i);
        if(st.size()==0){
            st.push(ch);
        }else if(ch == st.peek()){
            st.pop();
        }else st.push(ch);
    }
    if(st.size()==0)return "-1";
    StringBuilder sb = new StringBuilder();
    while(st.size()!=0){
        sb.append(st.pop());
    }
    
    return String.valueOf(sb.reverse());
    
    }
}
        
