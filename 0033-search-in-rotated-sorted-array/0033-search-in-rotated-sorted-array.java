class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int pivot = -1, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid]==target)
                return mid;
            if (nums[mid] >= nums[0])
                l = mid + 1;
            else
                r = mid - 1;
        }
        //System.out.println(l + " " + r);
        pivot = l;
        if (target >= nums[0])
            return bs(0, pivot - 1, nums, target);
        else
            return bs(pivot, n - 1, nums, target);
        //return l;
    }

    private int bs(int l, int r, int[] nums, int ele) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == ele)
                return mid;
            if (nums[mid] > ele)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}