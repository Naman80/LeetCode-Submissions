class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits = countBits(num2);
        int bits1 = countBits(num1);
        int ans = 0;
       if(bits==bits1)return num1;
        else if(bits1 > bits){
            for(int i = 31 ; i >=0 ; i--){
                if((num1 & (1 << i))!=0 && bits>0){
                    ans = ans|(1<<i);
                    bits--;
                }
                if(bits==0)return ans;
            }
        }else{
            int temp = bits - bits1;
            for(int i = 0 ; i < 32;  i++){
                if((num1 & (1 <<i)) == 0 && temp > 0){
                    num1 = num1 | (1 <<i);
                    temp--;
                }
                if(temp==0)return num1;
            }
        }
        
        return 0;
        
    }
    
    int countBits(int n){
        int count = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n & (1<<i))!=0)count++;
        }
        return count;
    }
}