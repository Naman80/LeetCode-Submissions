class Solution {
    public int romanToInt(String s) {
             int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();

        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int sum = 0;
        if(n==1){
            return hm.get(s.charAt(0));
        }
        for (int i=0;i<n-1;i++){
            int fr = hm.get(s.charAt(i));
            int sc = hm.get(s.charAt(i+1));
            if(fr<sc){
                int diff = sc - fr;
                if(diff % 4 ==0 || diff%9==0){
                    sum+=diff;
                    i++;
                }
            }else{
                sum+=fr;
            }
        }

        if(hm.get(s.charAt(n-1)) <= hm.get(s.charAt(n-2))){
            sum+=hm.get(s.charAt(n-1));
        }

        return sum; 
    }
}