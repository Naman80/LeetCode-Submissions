class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        List<String> ans =  pad("",digits);
       
        return ans;
    }
    
    static List<String> pad(String p,String up){
        if(up.length()==0){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        int f = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        if(f==7){
            for(int i = 15; i < 19 ;i++){
            char ch = (char) ('a' + i);
            // pad(p+ch,up.substring(1));
           ans.addAll(pad(p+ch,up.substring(1)));
        }
        }else if(f==8){
                for(int i = 19 ; i < 22 ;i++){
            char ch = (char) ('a' + i);
            // pad(p+ch,up.substring(1));
           ans.addAll(pad(p+ch,up.substring(1)));
        }
        }else if(f==9){
                    for(int i = 22 ; i < 26 ;i++){
            char ch = (char) ('a' + i);
            // pad(p+ch,up.substring(1));
           ans.addAll(pad(p+ch,up.substring(1)));
        }
     }else{
        for(int i = (f-2) * 3 ; i < (f-1) * 3 ;i++){
            char ch = (char) ('a' + i);
            // pad(p+ch,up.substring(1));
           ans.addAll(pad(p+ch,up.substring(1)));
        } 
        }
       
       
        return ans;
    }
}