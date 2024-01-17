class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        map<int,int>map;
        for(int x:arr)map[x]++;
        set<int>set;
        for(auto [a,b] : map)set.insert(b);
        return set.size() == map.size();
    }
};