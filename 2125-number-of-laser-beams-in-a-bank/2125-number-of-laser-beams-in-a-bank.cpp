class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int ans = 0;
        int temp = 0;
        for(string x : bank){
            int n = x.length();
            int count = 0;
            for(int i =0 ; i<n ; i++){
                if(x[i] == '1')count++;
            }
            if(count){
                ans+= temp * count;
                temp = count;
            }
        }
        return ans;
        
    }
};