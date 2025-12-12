class Solution {
    public void sortColors(int[] nums) {
        int l=0,m=0,h=nums.length-1;
        while(m<=h){
            if(nums[m]==0){
                int tmp=nums[m];
                nums[m]=nums[l];
                nums[l]=tmp;
                l++;
                m++;
            }else if(nums[m]==1)
                m++;
            else{
                int tmp=nums[m];
                nums[m]=nums[h];
                nums[h]=tmp;
                h--;
            }
           
        }
    }
}