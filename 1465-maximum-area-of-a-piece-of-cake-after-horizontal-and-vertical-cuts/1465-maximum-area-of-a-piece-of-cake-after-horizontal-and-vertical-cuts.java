class Solution {
    public int maxArea(int h, int w, int[] hC, int[] vC) {
        int mod = 1000000007;
        ArrayList<Integer> al1 = new ArrayList<>();
         ArrayList<Integer> al2 = new ArrayList<>();
        Arrays.sort(hC);
        Arrays.sort(vC);
        int n = hC.length;
        int m = vC.length;
        
        
        for(int i = 1 ; i < n;i++){
            al1.add(hC[i] - hC[i-1]);
        }
        
        al1.add(hC[0]);
        al1.add(h-hC[n-1]);
        
        for(int i = 1;i<m;i++){
            al2.add(vC[i] - vC[i-1]);
        }
        
        al2.add(vC[0]);
        al2.add(w-vC[m-1]);
        
        Collections.sort(al1);
        Collections.sort(al2);
        // System.out.println(al);
        long l = al1.get(al1.size()-1);
        long sl = al2.get(al2.size()-1);
        return (int)((l*sl)%mod);
    }
}