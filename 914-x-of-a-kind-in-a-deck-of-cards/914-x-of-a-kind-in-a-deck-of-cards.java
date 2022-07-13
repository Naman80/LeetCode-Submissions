class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if(n<=1)return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x : deck){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int gcd = 0;
        
        for(int num : map.values()){
            gcd = gcd(gcd,num);
        }
        
        return gcd>1;
        
    }
    
    public int gcd(int a , int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}