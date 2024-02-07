class Solution {
public:
    string frequencySort(string s) {
        priority_queue<pair<int,char>> pq;
        map<char,int>map;
        for(char ch :s)map[ch]++;
        for(auto [a,b] : map)pq.push({b,a});
        string ans = "";
        while(pq.size()){for(int i =0 ; i < pq.top().first;i++)ans+=pq.top().second;pq.pop();}
        return ans;
    }
};