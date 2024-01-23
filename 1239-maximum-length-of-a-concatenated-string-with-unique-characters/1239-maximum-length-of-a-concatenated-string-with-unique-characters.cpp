class Solution {
public:
    int ans = 0;
    
    void solve(int idx ,string s ,vector<int>&map, vector<string>& arr){
        if(idx>= arr.size())return ;
        for(char ch : arr[idx]){
            map[ch - 'a']++;
        }
        int mx = 0;
        for(int x : map)mx=max(mx ,x);
        string temp = s + arr[idx];
        if(mx==1){
            ans = max(ans , (int)temp.length());
            solve(idx+1 ,temp , map , arr);
        }
        for(char ch : arr[idx]){
            map[ch - 'a']--;
        }
        solve(idx+1, s ,map ,arr);
        
        
    }
    
    int maxLength(vector<string>& arr) {
        vector<int>map(26 , 0);
        solve(0 , "" , map , arr);
        return ans;
    }
};