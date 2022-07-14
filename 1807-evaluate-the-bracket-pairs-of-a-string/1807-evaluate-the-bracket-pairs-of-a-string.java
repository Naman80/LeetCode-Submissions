class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        
        for(List<String> x : knowledge){
            map.put(x.get(0),x.get(1));      
        }
        
        int state = 0;
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int n  = s.length();
        
        for(int i = 0 ; i < n ;i++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                state=1;
            }else if(ch==')'){
                if(map.containsKey(String.valueOf(sb2))){
                    sb.append(map.get(String.valueOf(sb2)));
                }else{
                    sb.append('?');
                }
                sb2 = new StringBuilder();
                state=0;
            }else{
                if(state == 0){
                    sb.append(ch);
                }else if(state == 1){
                    sb2.append(ch);
                }
            }
        }
        
        
        
        return String.valueOf(sb);
        
    }
    
}