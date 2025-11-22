class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2)
                        pal[i][j] = true;
                    else
                        pal[i][j] = pal[i + 1][j - 1];
                }
            }
        }
        int cut[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (pal[0][i])
                cut[i] = 0;
            else {
                int min = i;
                for (int j = 1; j <= i; j++) {
                    if (pal[j][i])
                        min = Math.min(min, cut[j - 1] + 1);
                }
                cut[i] = min;
            }
        }
        return cut[n-1];
    }

    int dp[][];

    private int solution1(String s) {
        dp = new int[s.length() + 1][s.length() + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(s, 0, s.length() - 1);
    }

    private int solve(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j))
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = 0, right = 0;
            if (isPalindrome(s, i, k)) {
                if (dp[i][k] != -1)
                    left = dp[i][k];
                else
                    left = solve(s, i, k);
            } else if (isPalindrome(s, k + 1, j)) {

                if (dp[k + 1][j] != -1)
                    right = dp[k + 1][j];
                else
                    right = solve(s, k + 1, j);
            }
            int tmp = left + right + 1;
            if (tmp < min)
                min = tmp;

        }
        dp[i][j] = min;
        return dp[i][j];
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}