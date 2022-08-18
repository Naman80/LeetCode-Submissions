class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int x : arr){
            map.putIfAbsent(x , 0);
            map.put(x , map.get(x) +1);
        }
        
        
        ArrayList<Integer> al = new ArrayList<>(map.values());
        Collections.sort(al);
        int count = 0;
        Collections.reverse(al);
        int sum = 0;
        for(int x : al){
            if(sum >= n/2)break;
            sum+=x;
            count++;
        }
        
        return count;
        
    }
}