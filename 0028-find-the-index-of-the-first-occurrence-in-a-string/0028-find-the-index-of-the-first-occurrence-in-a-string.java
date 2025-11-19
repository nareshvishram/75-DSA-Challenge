class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int lsp[] = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lsp[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0)
                    i = lsp[i - 1];
                else
                    j++;
            }
        }
        System.out.println(Arrays.toString(lsp));
        i = 0;
        j = 0;
        while (j < needle.length() && i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lsp[j - 1];
                else
                    i++;
            }
        }
        if (needle.length() == j)
            return i - j;
        return -1;
    }
}