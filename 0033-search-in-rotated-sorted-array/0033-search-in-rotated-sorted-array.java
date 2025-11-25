class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        //1. find pivot
        //2. find range
        //3. apply binary search

        //1. find pivot
        int pivot = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0])
                l = mid + 1;
            else
                r = mid - 1;
        }
        pivot = l;
        //2. find range
        if (target >= nums[0])
            return bs(0, pivot - 1, nums, target);

        return bs(pivot, n - 1, nums, target);

    }

    private int bs(int l, int r, int nums[], int target) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            System.out.println(l+" "+r+" "+mid);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}