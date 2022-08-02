class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int[] x : matrix){
            for(int y : x){
                 al.add(y);
            }
        }
        Collections.sort(al);
        
        return al.get(k-1);
    }
}