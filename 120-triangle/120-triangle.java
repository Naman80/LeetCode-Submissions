class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int size = triangle.size() - 1;
        
        for(int i = size - 1 ;i>=0;i--){
            List<Integer> al = triangle.get(i);
            int size1 = al.size();
            for(int j = 0 ; j < size1 ; j++){
                int num = al.get(j);
                List<Integer> al2 = triangle.get(i+1);
                int min = Math.min(num + al2.get(j) , num + al2.get(j+1));
                al.set(j,min);
            }
            
        }
        
        return triangle.get(0).get(0);
    }
}