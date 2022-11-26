class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        long ans = 0;
        int[] back = nseb(arr);
        int[] front = nsef(arr);
        for(int i = 0 ; i < n ; i ++){
            long temp = 0;
            temp+= (i - front[i])%mod;
            temp+= (back[i] - i-1)%mod;
            temp+= ((i - front[i]) - 1)*(back[i] - i-1)%mod;
            temp%=mod;
            ans+= (temp*arr[i])%mod;
            ans%=mod;
        }
        return (int)ans;
    }
    
    public int[] nseb(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans , n);
        Stack<Integer> st = new Stack<>();
        st.add(n-1);
        for(int i = n - 2 ; i >=0 ; i--){
            while(st.size()!=0 && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.size()!=0){
                ans[i] = st.peek();
            }
            st.push(i);   
        }   
        return ans;
    }
    public int[] nsef(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for(int i = 1 ; i<n ; i++){
            while(st.size()!=0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size()!=0){
                ans[i] = st.peek();
            }
            st.push(i);   
        }      
        return ans;
    }
    
    
    
}