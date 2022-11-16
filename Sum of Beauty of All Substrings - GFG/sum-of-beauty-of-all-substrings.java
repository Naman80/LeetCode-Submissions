//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int ans = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            // HashMap<Character , Integer> map = new HashMap<>();
            int[] map = new int[26];
            for(int j = i ; j < n; j++){
                char ch = s.charAt(j);
                map[ch - 'a']++;
                int max = -1;
                int min = 1000;
                for(int k = 0 ; k < 26 ; k++){
                    if(map[k]==0)continue;
                    max = Math.max(max , map[k]);
                    min = Math.min(min , map[k]);
                }
                ans += max - min;
                
            }
        }
        return ans;
    }
}
        
