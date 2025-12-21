class Solution {
    // 1. Find pivot
    // 2. Find the next greater
    // 3. Swap
    // 4. Reverse from (pivot, end]
    public void nextPermutation(int[] nums) {
        // 1. find pivot
        int n = nums.length;
        if (n <= 1)
            return;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // 2. find the next greater element i.e. greater than pivot
        int nextGreater = Integer.MAX_VALUE, idx = -1;
        for (int i = pivot + 1; i < n; i++) {
            if (nums[pivot] < nums[i]) {
                if (nextGreater >= nums[i]) {
                    nextGreater = nums[i];
                    idx = i;
                }
            }
        }
        // 3. swap
        int tmp = nums[pivot];
        nums[pivot] = nums[idx];
        nums[idx] = tmp;
        // 4. reverse
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int nums[], int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}