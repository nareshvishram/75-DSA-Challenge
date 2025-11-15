class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
           // System.out.println(mid+" "+(mid/n)+" "+(mid%n));
            if (matrix[mid / n][mid % n] == target)
                return true;
            if (matrix[mid / n][mid % n] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}