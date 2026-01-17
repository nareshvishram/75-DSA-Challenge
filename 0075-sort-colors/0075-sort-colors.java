class Solution {
    public void sortColors(int[] arr) {
        int l = 0, m = 0, r = arr.length - 1;
        while (m <= r && l <= r) {
            if (arr[m] == 0) {
                int tmp = arr[m];
                arr[m] = arr[l];
                arr[l] = tmp;
                l++;
                m++;
            } else if (arr[m] == 2) {
                int tmp = arr[m];
                arr[m] = arr[r];
                arr[r] = tmp;
                r--;
            } else {
                m++;
            }
        }
    }
}