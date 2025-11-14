class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0,i=0;
        while(fast<nums.length){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(fast==slow)
                break;
        }
        slow=0;
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}