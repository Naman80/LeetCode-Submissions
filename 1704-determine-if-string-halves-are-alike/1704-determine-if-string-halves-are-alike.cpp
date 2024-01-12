class Solution {
public:
    bool halvesAreAlike(string s) {
        set<char> set;
        set.insert('a');
        set.insert('e');
        set.insert('i');
        set.insert('o');
        set.insert('u');
        set.insert('A');
        set.insert('E');
        set.insert('I');
        set.insert('O');
        set.insert('U');
        int count = 0;
        int n = s.length();
        for(int i = 0 ; i < n/2;i++){
            if(set.find(s[i])!=set.end())count++;
        }
        for(int i = n/2 ; i < n ; i++){
            if(set.find(s[i]) != set.end())count--;
        }
        if(count ==0)return true;
        return false;
    }
};