public class FLoodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        dfs(sr,sc,image[sr][sc],newColor,image,image.length,image[0].length);
        return image;
  }
  private void dfs(int i,int  j,int orignalColor,int newColor,int[][] image,int m,int n){
      if(i<0||i>=m||j<0||j>=n||(image[i][j]!=orignalColor)) return ;
      image[i][j]=newColor;
      int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
      for(int[] d:dir){
          int new_i=i+d[0];
          int new_j=j+d[1];
          dfs(new_i,new_j,orignalColor,newColor,image,m,n);
      }
  }
}
