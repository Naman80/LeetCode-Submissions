class Solution 
{
public:

//Returns true if a path exists from board[i][j] to any valid index ...forming,'word'
bool helper(int row, int col, vector<vector<char>> &board, int k, string word)//'board[row][col]=word[0]' i.e., {row,col} is the starting index
{
    //Base Case[Destination reached]
    if(k==word.size())
       return true;
    // If we are moving outside the board's boundary , we return false
    if(row>=board.size() || col>=board[0].size() || row < 0 || col<0)
       return false;

    bool down,left,right,up = false;
    
    if(board[row][col] == word[k]){
        char ch = board[row][col];
        board[row][col] = '#';
        up = helper(row-1 , col , board , k+1 , word);
        if(up)return true;
        left = helper(row , col-1 , board , k+1 , word);
        if(left)return true;
        right = helper(row , col+1 , board , k+1 , word);
        if(right)return true;
        down = helper(row+1 , col , board , k+1 , word);
        if(down)return true;
        board[row][col] = ch;
        return false;
            
    }else return false;
}


bool exist(vector<vector<char>>& board, string word)
{
    //No visited array - cuz we can modify 'board'

    //Check if word[0] exist in board & present in board
    for(int row=0; row<board.size(); row++)
        for(int col=0; col<board[row].size(); col++)
            if(board[row][col]==word[0] && helper(row,col,board,0,word)) //**
               return true;
    
       return false;
}
};
