class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int,int>map;
        for(int x:arr)map[x]++;
        unordered_set<int>set;
        for(auto [a,b] : map){
            set.insert(b);
        }
        return set.size() == map.size();
    }
};