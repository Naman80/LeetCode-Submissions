class Solution {
    
    
public:
    struct compareFun{
        bool operator()(pair<int, char> p1, pair<int, char> p2) {
            if (p1.first == p2.first) return p1.second > p2.second;
            return p1.first < p2.first;
        }
    };
    
    string frequencySort(string s) {
      priority_queue<pair<int, char>, vector<pair<int, char>>, compareFun> pq;
        map<char,int>map;
        for(char ch :s)map[ch]++;
        for(auto [a,b] : map)pq.push({b,a});
        string ans = "";
        while(pq.size()){
            for(int i =0 ; i < pq.top().first;i++){
                ans+=pq.top().second;
            }
            pq.pop();
        }
        return ans;
    }
};