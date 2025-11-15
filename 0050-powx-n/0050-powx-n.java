class Solution {
    public double myPow(double x, int n) {
        if(x==-1 && n==Integer.MIN_VALUE)
            return 1;
        if(x==1 && (n==Integer.MAX_VALUE||n==Integer.MIN_VALUE))
            return 1;
        if (n < 0)
            return 1.0 / helper(x, n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0)
            return 1.0;
        double half = helper(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        return half * half * x;
    }
}