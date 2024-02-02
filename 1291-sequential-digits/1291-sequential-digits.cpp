class Solution {
public:
    vector<int> ans;
    bool solve(int idx , string temp ,int dig , int low, int high){
        if(idx == dig){
            int bar = stoi(temp);
            if(bar >= low  && bar <= high)ans.push_back(bar);
            return true;
        }
        if(idx>dig)return false;
        int b = temp[temp.size()-1]+1;
        if(b>57)return false;
        string foo(1, temp[temp.size()-1]+1);
        return solve(idx+1,temp+foo,dig,low,high);
    }
    vector<int> sequentialDigits(int low, int high) {
        int mind = to_string(low).size();
        int maxd = to_string(high).size();
        for(int j = mind ; j <= maxd ; j++){
            for(int i = 1 ; i <= 9 ; i ++){
                string temp(1, 48+i);
                if(solve(1 ,temp , j, low, high )==false)break;
            }
        }
        return ans;
    }
};