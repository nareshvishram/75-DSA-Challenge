class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int[] arr, int sum, int start, List<Integer> tmp) {
        if (start >= arr.length || sum < 0)
            return;
        if (sum == 0) {
            ans.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < arr.length; i++) {
            tmp.add(arr[i]);
            helper(arr, sum - arr[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}