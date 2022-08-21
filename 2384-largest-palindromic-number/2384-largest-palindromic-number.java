class Solution {
    public String largestPalindromic(String num) {
        int[] map = new int[10];
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        for(int i = 0 ; i < n;i++){
            int in = num.charAt(i) - '0';
            map[in]++;
        }    
        for(int i = 9 ; i >=0 ; i--){
            if(map[i]%2==1){
                map[i]--;
                sb.append(i);
                break;
            }
        }
        String temp = String.valueOf(sb);
        for(int i = 0 ; i <10 ; i++){
            if(map[i]>1){
                int times = map[i]/2;
                while(times-- >0){
                    sb.append(i);
                    sb.insert(0,i);
                }   
            }
        }
        if(temp=="" && map[0]!=0)return "0";
        if(sb.charAt(0)=='0')return temp;
        return String.valueOf(sb);  
    }
}