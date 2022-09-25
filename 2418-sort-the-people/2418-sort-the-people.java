class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] ans = new String[names.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ;i++){
            pq.add(new Pair(names[i] , heights[i]));
        }
        int i = 0;
        while(pq.size()!=0){
            Pair out = pq.poll();
            ans[i] = out.name;
            i++;
        }
        return ans;
    }   
}
class Pair implements Comparable<Pair>{
    String name;
    int val;
    Pair(String name , int val){
        this.name = name;
        this.val = val;
    }
    @Override
    public int compareTo(Pair o){
        return o.val - this.val;
    }
}