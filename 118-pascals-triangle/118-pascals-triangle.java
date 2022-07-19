class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp, prev = null;
        
        for(int i = 0;i<numRows;i++){
            temp = new ArrayList<Integer>();
            for(int j = 0 ;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(prev.get(j-1) + prev.get(j));
                }
            }
        res.add(temp);
        prev = temp;
        }
        return res;
        
        
    }
}