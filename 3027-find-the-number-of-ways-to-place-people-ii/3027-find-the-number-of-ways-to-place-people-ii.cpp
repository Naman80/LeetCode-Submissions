class Solution {
public:
    int numberOfPairs(vector<vector<int>>& nums) {
        
        // way to insert comparator in sorting function
        // [](auto a , auto b){return ;}
        
        int ans=  0;
        int n = nums.size();
        vector<pair<int,int>> A;
        for(auto x: nums){
            A.push_back({x[0],x[1]});
        }
        sort(A.begin() , A.end(), [](auto a,auto b){
            if(a.first == b.first) return a.second > b.second;
                return a.first < b.first;
        });
        // for(auto x : A){
        //     cout << x.first << " " <<x.second <<  endl;
        // }
         for (int i = 0; i < n; ++i) {
            int y = -2e9;
            for (int j = i + 1; j < n; ++j)
                if (A[i].second >= A[j].second && A[j].second > y)
                    ans++, y = A[j].second;
        }
        return ans;
        
        // for(int i = 0 ;  i <  n ; i++){
        //     for(int j = 0 ; j < n ; j ++){
        //         if(j==i)continue;
        //         if(nums[i][0]<= nums[j][0] && nums[i][1] >= nums[j][1]){
        //             int check = 1;
        //             for(int k = 0 ; k < n ; k ++){           
        //                 if(k==i || k==j)continue; 
        //                 if(nums[k][0] >= nums[i][0] && nums[k][0] <= nums[j][0] && nums[k][1] <= nums[i][1] && nums[k][1] >= nums[j][1]){check = 0;break;}    
        //             }
        //             if(check)ans++;
        //         }
        //     }
        // }
        return ans;
    }
};