class Solution {
    public List<String> findAndReplacePattern(String[] w, String p) {
        List<String> ans = new ArrayList<>();
        int plen = p.length();
        for(String s : w){
            if(s.length()!=plen)continue;
            HashMap<Character , Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            boolean check = true;
            for(int i = 0 ; i < s.length() ;i++){
                char p_ch  = p.charAt(i);
                char s_ch = s.charAt(i);
                if(!map.containsKey(s_ch) && set.contains(p_ch)){check = false ;break;}
                if(map.containsKey(s_ch) && map.get(s_ch) != p_ch){check = false ;break;}
                map.putIfAbsent(s_ch , p_ch);
                set.add(p_ch);
            }
            if(check)ans.add(s);
        }
        return ans;
    }
}