class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
       int idx = 0;
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i =0  ; i < n ; i ++){
            int temp = Math.abs( x - arr[i]);
            if(temp < diff){
                diff = temp;
                idx = i;
            }
        }
        int i = idx ;
        int j = idx+1;
        // System.out.println(idx);
        // if(arr[idx] == x){
        //     ans.add(x);
        //     k--;
        //     i--;
        // }
        while(k >0 ){   
            
            if(i>=0 && j <n){
                int temp = Math.abs(arr[i] - x);
                int temp1 = Math.abs(arr[j] - x);
                if(temp <= temp1){
                    ans.add(arr[i]);
                    i--;
                }else{
                    ans.add(arr[j]);
                    j++;
                }
                k--;
            }
            else if(k > 0 && i >=0){
                ans.add(arr[i]);
                i--;
                k--;
            }
             else if(k > 0 && j < n){
                ans.add(arr[j]);
                j++;
                k--;
            }
            
        }
        
        Collections.sort(ans);
        return ans;
    }
}