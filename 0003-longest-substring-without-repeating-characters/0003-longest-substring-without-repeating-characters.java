class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[200];
        Arrays.fill(map, -1);
        int left = 0, right = 0, n = s.length();
        int ans = 0;
        while (right < n) {
            int prevOcc = map[s.charAt(right)];
            if (prevOcc >= left) {
                left = prevOcc + 1;
            }
            map[s.charAt(right)] = right;
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}