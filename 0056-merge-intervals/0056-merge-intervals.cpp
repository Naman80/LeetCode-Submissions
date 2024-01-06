class Solution {
public:
    
    vector<int> mergeTwo(int x , int y , int x1 , int y1){
        vector<int> temp;
        temp.push_back(x);
        temp.push_back(max(y , y1));
        return temp;
    }
    
    vector<vector<int>> merge(vector<vector<int>>& arr) {
        vector<vector<int>> ans;
        sort(arr.begin() , arr.end());
        ans.push_back(arr[0]);
        int n = arr.size();
        for(int i = 1 ;i < n ; i++){
            int len = ans.size();
            if(ans[len-1][1] >= arr[i][0]){
                ans[len-1] = mergeTwo(ans[len-1][0] ,ans[len-1][1],arr[i][0],arr[i][1] );
            }else ans.push_back(arr[i]);
        }
        
        return ans;
    }
};