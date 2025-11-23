class Solution {
    int dp[][] = new int[101][101];

    public int uniquePaths(int m, int n) {
        // for (int x[] : dp)
        //     Arrays.fill(x, -1);
        // return dfs(0, 0, new boolean[m][n], m, n);
        return tabulation(m,n);
    }

    private int dfs(int i, int j, boolean[][] vis, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == m - 1 && j == n - 1)
            return 1;
        vis[i][j] = true;
        dp[i][j] = dfs(i + 1, j, vis, m, n) + dfs(i, j + 1, vis, m, n);
        return dp[i][j];
    }

    private int tabulation(int m,int n){
        int t[][]=new int[m][n];
        for(int i=0;i<n;i++)
            t[0][i]=1;
        for(int j=0;j<m;j++)
            t[j][0]=1;
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}