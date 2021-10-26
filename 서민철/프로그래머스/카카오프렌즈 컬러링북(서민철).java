class Solution {
    static int area;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                visited[i][j] = false;
            }
        }
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                area = 0;
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea += 1;
                    DFS(i, j, visited, picture);
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    public void DFS(int y, int x, boolean[][] visited, int[][] picture) {
        area += 1;
        visited[y][x] = true;
        
        int[] dirY = { 0, 0, -1, 1 };        
        int[] dirX = { -1, 1, 0, 0 };
        
        for (int i = 0; i < 4; i ++) {
            int posY = y + dirY[i];
            int posX = x + dirX[i];
            if (isVisitable(posY, posX, visited) && picture[y][x] == picture[posY][posX]) {
                DFS(posY, posX, visited, picture);
            }
        }
    }
    
    public boolean isVisitable(int y, int x, boolean[][] visited) {
        return(0 <= y) && (y < visited.length) && (0 <= x) && (x < visited[0].length) && !visited[y][x];
    }
}