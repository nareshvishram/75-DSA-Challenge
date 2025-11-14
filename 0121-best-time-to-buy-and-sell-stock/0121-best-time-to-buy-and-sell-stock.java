class Solution {
    public int maxProfit(int[] prices) {
        int tmp=0,sum=0;
        for(int i=1;i<prices.length;i++){
            int imp=prices[i]-prices[i-1];
            tmp=Math.max(tmp+imp,imp);
            if(tmp>sum)
                sum=tmp;
        }
        return sum;
    }
}