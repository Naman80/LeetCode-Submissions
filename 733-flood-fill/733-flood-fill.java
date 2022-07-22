class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)return image;
        int n = image.length;
        int m = image[0].length;
        int incol = image[sr][sc];
        boolean[][] vis = new boolean[n][m];
        vis[sr][sc] = true;
        
        int[] xdir = {0,1,-1,0};
        int[] ydir = {1,0,0,-1};
        
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(sr,sc));
        
        while(q.size()!=0){
            
            pair out = q.poll();
            int x = out.x;
            int y = out.y;
            image[x][y] = newColor;
            for(int i = 0 ; i < 4; i++){
                int newx = x + xdir[i];
                int newy = y + ydir[i];
                
                if(newx <0 ||  newy < 0 || newx >= n || newy >= m || vis[newx][newy] || image[newx][newy] != incol)continue;
                
                vis[newx][newy] = true;
                q.add(new pair(newx,newy));
                
            }
            
        }
        
        return image;
        
    }
}

class pair{
    
    int x;int y;
    pair(int x , int y){
        this.x = x;
        this.y = y;
    }
    
}