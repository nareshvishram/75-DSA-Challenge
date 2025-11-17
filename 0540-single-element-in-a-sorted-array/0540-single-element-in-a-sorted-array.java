class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1;
        if(n==1)
            return nums[0];
        if(n==3)
            if(nums[0]==nums[1])
                return nums[n-1];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];
        if(nums[0]!=nums[1])
            return nums[0];
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1])
                return nums[mid];
            if(nums[mid-1]==nums[mid]){
                // eo => go to right
                if((mid-1)%2==0)
                    l=mid+1;
                else
                    r=mid+1;
            }else{
                if((mid+1)%2==0)
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return -1;
    }
}