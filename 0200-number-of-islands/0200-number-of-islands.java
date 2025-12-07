class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid.length, grid[0].length, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(i + 1, j, m, n, grid);
        dfs(i - 1, j, m, n, grid);
        dfs(i, j + 1, m, n, grid);
        dfs(i, j - 1, m, n, grid);
    }
}