class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb=new StringBuilder("");
        int cnt=0;
        int limit=100000;
        while(sb.indexOf(b)==-1){
            sb.append(a);
            cnt++;
             if (sb.length() > 10000)
                return -1;
        }
        return cnt;
    }
}