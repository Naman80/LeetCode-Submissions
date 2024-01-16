class RandomizedSet {
public:
    unordered_set<int> removedIdx;
    unordered_map<int,int> idx_val;
    unordered_map<int,int> val_idx;
    int idx = 1;
    RandomizedSet() {
        removedIdx.clear();
        idx_val.clear();
        val_idx.clear();
    }
    
    bool insert(int val) {
        if(val_idx[val] != 0) return false;
        if(removedIdx.size()!=0){
            int ridx = *removedIdx.begin();
            idx_val[ridx] = val;
            val_idx[val] = ridx;
            removedIdx.erase(ridx);
        }else{
            idx_val[idx] = val;
            val_idx[val] = idx;
            idx++;
        }
        return true;
    }
    
    bool remove(int val) {
        if(val_idx[val] == 0) return false;
        int ridx = val_idx[val];
        val_idx.erase(val);
        idx_val.erase(ridx);
        removedIdx.insert(ridx);
        return true;
    }
    
    int getRandom() {
        int ridx = (rand() % (idx-1))+1;
        while(removedIdx.find(ridx)!=removedIdx.end()){
          ridx = (rand() % (idx-1))+1;  
        }
        return idx_val[ridx];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */