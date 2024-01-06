class Solution {
public:
    
    int bs(int idx , int s , int e ,vector<vector<int>>& arr  ){
        while(e>s){
            int mid = (e+s)/2;
            if(arr[idx][1] > arr[mid][0])s=mid+1;
            else e = mid;
        }   
        if(e<s)return -1;
        return e;
    }
    int findNext(int idx ,int& n , vector<vector<int>>& arr){
        
        for(int i = idx+1 ; i < n ; i++){
            if(arr[idx][1] <= arr[i][0])return i;
        }
        return -1;
    }
    int solve(int idx ,int& n , vector<vector<int>>& arr , vector<int>& dp){
        if(idx>=n)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int next = bs(idx ,idx+1,n, arr);
        int take = arr[idx][2];
        if(next!=-1){
                take += solve(next,n, arr,dp);
        } 
        int nottake = solve(idx+1 ,n, arr ,dp);
        return dp[idx] = max(take , nottake);
    }    
    int jobScheduling(vector<int>& st, vector<int>& et, vector<int>& p) {
        vector<vector<int>> arr;
        int n = p.size();
        for(int i = 0;  i < n ; i++){
            vector<int> temp;
            temp.push_back(st[i]);
            temp.push_back(et[i]);
            temp.push_back(p[i]);
            arr.push_back(temp);
        }
        sort(arr.begin() , arr.end());
        vector<int> dp(n+1,-1);
        return solve(0 ,n, arr , dp);
    }
};