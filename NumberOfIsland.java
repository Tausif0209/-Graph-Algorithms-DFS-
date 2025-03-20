class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0' || isVisited[i][j]) continue;
                island++;
                dfs(i,j,isVisited,grid,m,n);
            }
        }
        return island;
    }
    void dfs(int i,int j,boolean[][] isVisited,char[][] grid,int m,int n){
        if(i<0 || i==m || j<0 || j==n || isVisited[i][j] || grid[i][j]=='0') return ;
        isVisited[i][j]=true;
        int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        for(int[] d:dir){
            int new_i=i+d[0];
            int new_j=j+d[1];
            dfs(new_i,new_j,isVisited,grid,m,n);
        }
    }
}