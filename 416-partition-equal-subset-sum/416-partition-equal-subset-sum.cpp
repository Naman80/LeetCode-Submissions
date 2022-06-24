class Solution {
public:
    bool canPartition(vector<int>& A) {
         int N = A.size();
        int S = accumulate( A.begin() , A.end() , 0 );
        if( S&1 )
            return 0 ;
        S = S/2 ;
        
        int t[N+1][S+1];
        memset(t , 0 , sizeof t );
        
        for( int i = 0 ; i <= N ; i++ )
            t[i][0] = 1 ;
        
        for( int i = 1 ; i <= N ; i++ )
        for( int j = 1 ; j <= S ; j++ )
            if( j < A[i-1] )
                t[i][j] = t[i-1][j];
            else
                t[i][j] = t[i][j] | t[i-1][j] | t[i-1][j-A[i-1]];
        
        return t[N][S];
    }
};