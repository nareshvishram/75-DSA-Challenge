class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000);
        int i = s.length() - 1, ans = 0;
        while (i >= 0) {
            int a = map.get(s.charAt(i) + "");
            if (i == s.length() - 1)
                ans += a;
            else {
                if (a < map.get(s.charAt(i + 1) + ""))
                    ans -= a;
                else
                    ans += a;
            }
            i--;
        }
        return ans;
    }
}