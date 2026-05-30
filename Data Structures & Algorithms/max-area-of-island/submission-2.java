class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    int area = bfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int bfs(int i, int j, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = 0;
        int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        q.offer(new int[] {i,j});
        int area = 1;
        
        while(!q.isEmpty()){
            int[] val = q.poll();

            for(int[] dir : dirs){
                int nRow = dir[0] + val[0];
                int nCol = dir[1] + val[1];
                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length 
                    && grid[nRow][nCol] == 1){
                    q.offer(new int[] {nRow, nCol});
                    grid[nRow][nCol] = 0;
                    area++;
                }
            }
        }
        return area;
    }
}
