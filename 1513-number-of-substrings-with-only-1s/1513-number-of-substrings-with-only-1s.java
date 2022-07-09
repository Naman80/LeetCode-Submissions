class Solution {
    public int numSub(String s) {
        
        int i = 0 ;
        int j = 0 ;
        int n = s.length();
        int mod = 1000000007;
        long ans= 0;
        while( i < n && j < n && j >= i){
            
            
            while(i<n && s.charAt(i)=='0'){
                i++;
            }
            j = i;
            
            while(j < n && s.charAt(j) == '1'){
                j++;
            }
            
            
            if(j >= i){
                int len = j - i;
                // System.out.println(len);
                long sub = 1;
                if(len%2==0){
                    sub*=len/2;
                    sub*=len+1;
                }else{
                    sub*= (len+1)/2;
                    sub*= len;
                }
                ans = (ans%mod + sub%mod)%mod;   
                i = j;
            }
            
        }
        
        return (int)ans;
    }
    
    
    
    
}