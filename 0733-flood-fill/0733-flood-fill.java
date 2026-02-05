class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        int n = image.length;
        int m = image[0].length;
        flood(sr,sc,image,oldColor,color,n,m);
        return image;
    }
    public void flood(int r,int c,int[][] image,int oldColor,int newColor,int n,int m){
        if(r<0 || c<0 || r==n || c==m || image[r][c]!=oldColor) return;
        image[r][c] = newColor;
        for(int i = 0; i < 4; i++){
            flood(r + dr[i], c + dc[i], image, oldColor, newColor, n, m);
        }
    }
}