class Solution {
       public String largestTimeFromDigits(int[] A) {
        for(int h = 23; h >= 0; h--) {
            for(int m = 59; m >= 0; m--) {
                
                boolean flag = true;
                int[] count = new int[10];
                
                count[h < 10 ? 0 : h / 10]++;
                count[h < 10 ? h : h % 10]++;
                count[m < 10 ? 0 : m / 10]++;
                count[m < 10 ? m : m % 10]++;                

                
                for(int e : A) {
                    if(--count[e] < 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) return String.format("%02d:%02d", h, m);
            }
        }
        
        return "";
    }
}