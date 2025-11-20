class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        if (n == 1)
            return new int[] { nums[0] };
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k != 0) {
                left[i] = Math.max(left[i - 1], nums[i]);
            } else {
                left[i] = nums[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (i % k != 0) {
                right[i] = Math.max(right[i + 1], nums[i]);
            } else {
                right[i] = nums[i];
            }
        }

        int ans[] = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            ans[j++] = Math.max(right[i], left[i + k - 1]);
        }
        return ans;
    }
}