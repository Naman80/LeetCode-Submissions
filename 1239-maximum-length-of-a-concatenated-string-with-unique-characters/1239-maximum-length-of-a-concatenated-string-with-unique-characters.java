class Solution {
    public int maxLength(List<String> arr) {
         ArrayList<String> al = new ArrayList<>();

        for(String x : arr){
            boolean check = true;
            Set<Character> st = new HashSet<>();
            for (int i = 0; i < x.length(); i++) {
                if (st.contains(x.charAt(i))){
                    check = false;
                    break;
                }
                st.add(x.charAt(i));
            }
            if (check)al.add(x);
        }
        return solve(0,al,new HashSet<>());
    }
    
    
    
    public static int solve(int idx , ArrayList<String> arr, Set<Character> st){

        if(idx>= arr.size()){
            return st.size();
        }
        boolean check = true;
        for(int i = 0 ; i < arr.get(idx).length();i++){
            char ch = arr.get(idx).charAt(i);
            if(st.contains(ch)){
                check = false;break;
            }
        }
        int pick = 0;
        if(check){
            for(int i = 0 ; i < arr.get(idx).length();i++){
                char ch = arr.get(idx).charAt(i);
                st.add(ch);
            }
            pick = solve(idx+1,arr,st);
            for(int i = 0 ; i < arr.get(idx).length();i++){
                char ch = arr.get(idx).charAt(i);
                st.remove(ch);
            }
        }

        int np = solve(idx+1,arr,st);


        return Math.max(pick,np);

    }
}



