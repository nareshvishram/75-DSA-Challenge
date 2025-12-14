class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int ans = Integer.MIN_VALUE, pre = 1, suff = 1;
        for (int i = 0; i < nums.length; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre = pre * nums[i];
            suff = suff * nums[n - i - 1];
            res = Math.max(Math.max(pre, suff), res);
        }
        return res;
    }
}