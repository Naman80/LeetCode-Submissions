class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int n = wordList.size();
        if(!wordList.contains(endWord))return 0;
        HashMap<String , Boolean> map = new HashMap<>();
        for(String x : wordList){
            map.put(x,false);
        }
        int ans = 1;
        map.put(beginWord,true);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        while(q.size()!=0){
            int size = q.size();
            for(int i = 0 ; i< size ;i++){
                String out = q.poll();
                if(out.equals(endWord))return ans;
                addNew(out,q,map);
            }
            ans++;
        }
        return 0;
    }
    
    void addNew(String out, Queue<String> q , HashMap<String , Boolean> map){
        
        
        int n = out.length();
        
        for(int i = 0 ; i  < n;i++){
            char[] w = out.toCharArray();
            for(int j = 0 ; j < 26;j++){
                char ch = (char)(97+j);
                w[i] = ch;
                String temp = String.valueOf(w);
            
                if(map.containsKey(temp) && map.get(temp)==false){
                    q.add(temp);
                    map.put(temp , true);
                }
            }
            
        }
        
        
        
    }
    
    
}