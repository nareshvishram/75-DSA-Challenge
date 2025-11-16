class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long req=target-(long)nums[i]-(long)nums[j];
                int l=j+1,r=n-1;
                while(l<r){
                    if(nums[l]==req-nums[r]){
                        al.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<n-1 && nums[l]==nums[l+1])
                            l++;
                        l++;r--;
                    }
                    else if(nums[l]+nums[r]>req)
                        r--;
                    else
                        l++;
                }
                while(j<n-1 && nums[j]==nums[j+1])
                    j++;
            }
            while(i<n-1 && nums[i]==nums[i+1])
                i++;
        }
        return al;
    }
}