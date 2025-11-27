class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int arr[], int sum, int start, List<Integer> tmp) {
        if (sum < 0)
            return;
        if (sum == 0)
            ans.add(new ArrayList<>(tmp));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;
            tmp.add(arr[i]);
            helper(arr, sum - arr[i], i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}