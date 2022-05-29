class Solution {
    public int maxProduct(String[] words) {
        HashSet<Character> hs  = new HashSet<>();
        int n = words.length;
        int max = 0;
        for(int i= 0;i<n-1;i++){
            hs.clear();
            String out = words[i];
            for(int x =0;x<out.length();x++){
                hs.add(out.charAt(x));
            }
            
            for(int j = i+1;j<n;j++){
                boolean check =  true;
                String out2 = words[j];
                for(int x =0;x<out2.length();x++){
                if(hs.contains(out2.charAt(x))){
                    check = false;
                    break;
                }
            }
                if(check){
                    max = Math.max(max,out.length() * out2.length());
                }
            }
        }
        
        return max;
    }
}