class SmallestInfiniteSet {
public:
    set<int> set;
    priority_queue<int,vector<int>,greater<int>> pq;
    SmallestInfiniteSet() {
        
        for(int i = 1 ; i < 1001;i++){
            set.insert(i);
            pq.push(i);
        }
        
    }
    
    int popSmallest() {
        int in = pq.top();
        set.erase(in);
        pq.pop();
        return in;
    }
    
    void addBack(int num) {
        
        if(set.find(num) == set.end()){
            pq.push(num);
            set.insert(num);
        }
        
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */