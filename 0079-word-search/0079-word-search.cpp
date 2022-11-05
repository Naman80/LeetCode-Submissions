//**  -> If 1st is true & 2nd is not true, it may be possible that board[i][j] is present somewehere else in the 'board' too
//For eg, board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE" -> board[1][0]=board[1][3]="S"

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
    if(row>=board.size() || col>=board[0].size() )
       return false;
    
    //first going 'down'
    if(row+1<=board.size() && board[row][col] == word[k])
    {
        char ch=board[row][col];
        board[row][col]='#';
        if( helper(row+1,col,board,k+1,word)) return true;
        board[row][col]=ch;
    }

    //second going 'left'
    if(col-1>=0 && board[row][col] == word[k])
    {
        char ch=board[row][col];
        board[row][col]='#';
        if(helper(row,col-1,board,k+1,word)) return true;
        board[row][col]=ch;
    }

    //third going 'right'
    if(col+1<=board[0].size() && board[row][col] == word[k])
    {
        char ch=board[row][col];
        board[row][col]='#';
        if(helper(row,col+1,board,k+1,word)) return true;
        board[row][col]=ch;
    }

    //fourth going 'up'
    if(row-1>=0 && board[row][col] == word[k])
    {
        char ch=board[row][col];
        board[row][col]='#';
        if(helper(row-1,col,board,k+1,word)) return true;
        board[row][col]=ch;
    }

     //in any other case,
     return false;
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