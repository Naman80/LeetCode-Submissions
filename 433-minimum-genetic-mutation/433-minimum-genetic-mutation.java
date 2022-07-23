class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        HashMap<String , Boolean> map = new HashMap<>();
        for(String s : bank){
            map.put(s,false);
        }
        if(!map.containsKey(end))return -1;
        
        Queue<String> q = new LinkedList<>();
        
        
        map.put(start,true);
        q.add(start);
        int ans = 0;
        while(q.size()!=0){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                String out = q.poll();
                if(out.equals(end))return ans;
                addNew(out,map,q);
            }
            ans++;   
        }
        return -1;
    }

    void addNew(String out , HashMap<String , Boolean> map , Queue<String> q){   
        int n = out.length();
        for(int i = 0 ; i < n ;i++){
            char[] arr = out.toCharArray();
            for(int j = 0 ;j < 4 ;j++){
                if(j==0){
                    arr[i] = 'A';
                }else if(j==1){
                    arr[i] = 'C';
                }else if(j==2){
                    arr[i] = 'G';
                }else{
                    arr[i] = 'T';
                }
                String temp = String.valueOf(arr);
                if(map.containsKey(temp) && map.get(temp)==false){
                    q.add(temp);
                    map.put(temp,true);
                }   
            }   
        }
    }
}