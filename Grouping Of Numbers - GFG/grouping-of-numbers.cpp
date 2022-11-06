//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int maxGroupSize(int arr[], int N, int K) {
        // code here
        
        unordered_map<int,int> mapi;
        // for(int i = 0 ; i < K ; i++)map.put(i , 0);
        for(int i = 0 ; i < N ; i ++){
            arr[i] = arr[i]%K;
            mapi[arr[i]]++;
        }
        int ans = 0;
        if(mapi[0]>0)ans++;
        for(int i =1 ; i <= K/2 ; i++){
            if(i == K - i && mapi[i]>0){
                ans++;
            }else{
                ans+= max(mapi[i] , mapi[K-i]);
            }
        }
        return ans;
        
        
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N,K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution ob;
        cout << ob.maxGroupSize(arr,N,K) << endl;
    }
    return 0;
}
// } Driver Code Ends