// ["()"]
// ["(())","()()"]
// ["((()))","(()())","(())()","()(())","()()()"]
// ["(((())))","((()()))","((())())",
    // "((()))()","(()(()))","(()()())",
    // "(()())()","(())(())","(())()()",
    // "()((()))","()(()())","()(())()",
    // "()()(())","()()()()"]




class Solution {
    public List<String> generateParenthesis(int n) {
//         HashSet<String> num = new LinkedHashSet<String>();
//         num.add("()");
//         while(n-- > 1){
//             HashSet<String> newnum = new LinkedHashSet<String>();
//             for(String x : num){
//                 newnum.add("(" + x + ")");
                
//             }
//             for(String x:num){
//                 newnum.add(x + "()");
//                 newnum.add("()"+x);
//             }
            
//             num = newnum;
//         }
        
//         return new ArrayList<String>(num);
        
          List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String right: generateParenthesis(n-1-c))
                    for (String left: generateParenthesis(c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;

        // List<String> al = new ArrayList<>();
        // solve(0,0,n,"",al);return al;
        
    }
    
    void solve(int open,int close,int n,String s,List<String> al){
        if(open==n && close == n){
        al.add(s);return;
        }    
        if(open < n){
            solve(open+1,close,n,s+"(",al);
        }
        if(close<open){
        solve(open,close+1,n,s+")",al);
        }
    }
    
    
    
    
    
    
    
    
}