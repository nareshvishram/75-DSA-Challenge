class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length) {
                if (g[i] <= s[j]) {
                    ans++;
                    j++;
                    break;
                }else
                    j++;
                
                if (j >= s.length)
                    return ans;
            }
        }
        return ans;
    }
}