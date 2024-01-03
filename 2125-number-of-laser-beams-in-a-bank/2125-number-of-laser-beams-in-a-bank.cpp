class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int ans = 0;
        int temp = 0;
        for(string x : bank){
            int count = 0;
            for(char  c : x)if(c == '1')count++;            
            if(count){
                ans+= temp * count;
                temp = count;
            }
        }
        return ans;
    }
};