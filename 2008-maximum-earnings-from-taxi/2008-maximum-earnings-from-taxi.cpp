#define ll long long
class Solution {
public:
    
    int bs(int idx , int s , int e ,vector<vector<ll>>& arr  ){
        while(e>s){
            int mid = (e+s)/2;
            if(arr[idx][1] > arr[mid][0])s=mid+1;
            else e = mid;
        }   
        if(e<s)return -1;
        return e;
    }
    
    ll solve(int idx ,int n, vector<vector<ll>>& rides , vector<ll>& dp){
        if(idx >=n )return 0LL;
        if(dp[idx]!=-1)return dp[idx];
        ll take = 0;
        ll notTake = 0;
        int next = bs(idx , idx+1 , n , rides);
        take = rides[idx][2];
        if(next!=-1)take+=solve(next, n, rides,dp);
        notTake = solve(idx+1,n , rides,dp);
        return dp[idx]= max(take , notTake);
    }
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        n = rides.size();
        vector<vector<ll>> pRides;
        vector<ll> dp(n , -1);
        for(int i = 0 ; i < rides.size() ; i++){
            auto x  = rides[i];
            vector<ll>temp;
            ll val = x[1]*1LL - x[0] + x[2];
            temp.push_back(x[0]*1LL);
            temp.push_back(x[1]*1LL);
            temp.push_back(val*1LL);
            pRides.push_back(temp);
        }
        sort(pRides.begin() , pRides.end());
        return solve( 0, n , pRides,dp);
    }
};