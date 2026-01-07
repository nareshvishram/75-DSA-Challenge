class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        int suff[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pref[i] = 1;
                suff[n - i - 1] = 1;
            } else {
                pref[i] = pref[i - 1] * nums[i - 1];
                suff[n - i - 1] = suff[n - i] * nums[n - i];
            }
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pref[i] * suff[i];
        }
        return ans;
    }
}

/**

arr=[1,2,3,4]
pref=[1,1,2,6]
suff=[24,12,4,1]
ans=[1*24,1*12,2*4,6*1]
for i:
    pref[i]*suff[i]

arr=[-1,-1,0,-3,3]
pref=[1,-1,1,0,0]
suff=[0,0,-9,3,1]
ans=[0,0,-9,0,0]
 */