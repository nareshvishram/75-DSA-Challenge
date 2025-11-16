class Solution {
    public int longestConsecutive(int[] nums) {
        int count=0,ans=0;
        Set<Integer> map=new HashSet<>();
        for(int i=0;i<nums.length;i++)
            map.add(nums[i]);
        for(int i=0;i<nums.length;i++){
            if(!map.contains(nums[i]-1)){
                int start=nums[i];
                while(map.contains(start)){
                    map.remove(start);
                    count++;
                    start++; 
                }
            }
            ans=Math.max(count,ans);
            count=0;
            
        }
        return ans;
    }
}