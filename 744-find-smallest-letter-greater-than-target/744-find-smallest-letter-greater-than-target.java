class Solution {
    public char nextGreatestLetter(char[] l, char target) {
        int n =  l.length;
        int tar = target - 'a';
        if(l[n-1] - 'a' <= tar) return l[0];
        int i = 0;
        int j = n-1;
        int mid = 0;
        while(i<=j){
            mid = i + (j-i)/2;
            if(l[mid] - 'a' == tar){
                for(int s = mid;s<n;s++){
                    if(l[s] - 'a' != tar) return l[s];
                }
                
            }
            if(l[mid] - 'a' > tar) j = mid - 1;
            else i = mid + 1;
        }
        
        return l[i];
        
    }
}