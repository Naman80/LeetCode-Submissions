class Solution {
public:
    bool isPowerOfTwo(int n) {
        long long a = n;
        if(a!=0 && (a & (a-1))==0)return true;
        return false;
    }
};