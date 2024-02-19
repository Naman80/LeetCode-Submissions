class Solution {
public:
    bool isPowerOfTwo(int n) {
        int temp = __builtin_popcountl(n);
        // cout << -pow(2,31);
        if(temp==1)return true;
        
        return false;
    }
};