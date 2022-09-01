class Solution {
    public String smallestSubsequence(String s) {
        
        int n = s.length();
        
        HashSet<Character> vis = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        Stack<Character> st= new Stack<>();
        for(int i = 0 ; i < n ;i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch , 0);
            map.put(ch , map.get(ch)+1);
        }
        for(int i = 0 ; i < n ; i ++){
            char ch = s.charAt(i);
            if(!vis.contains(ch)){
                if(st.size()==0 || st.peek() < ch){
                    st.push(ch);
                    vis.add(ch);
                    map.put(ch , map.get(ch)-1);
                }else{
                    while(st.size()>0 && st.peek() > ch && map.get(st.peek())>0){
                        vis.remove(st.peek());
                        st.pop();
                    }
                    st.push(ch);
                    vis.add(ch);
                    map.put(ch , map.get(ch)-1);
                }      
            }else{
                map.put(ch , map.get(ch)-1);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(st.size()!=0){
            ans.insert(0 , st.pop());
        }
        
        return String.valueOf(ans);
        
    }
}