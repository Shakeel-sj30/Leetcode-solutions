class Solution {
    private int counting(int[] nums, int goal ){
        int count =0;
        int left=0;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            if(goal<0){
                return 0;
            }
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;

        }
        return count;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return counting(nums, goal) - counting(nums,goal-1);
        
        
        
    }
}