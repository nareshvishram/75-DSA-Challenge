class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return ans;
    }

    private void helper(String str, int start, List<String> tmp) {
        if (start == str.length()) {
            ans.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str.substring(start, i + 1))) {
                tmp.add(str.substring(start, i + 1));
                helper(str,i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}