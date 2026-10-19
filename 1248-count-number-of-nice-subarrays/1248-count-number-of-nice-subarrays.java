class Solution {
    private int nice(int [] nums, int k){
        int count =0;
        int left =0;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            if(k<0){
                return 0;

            }
            sum+=nums[right]%2;
            while(sum>k){
                sum-=nums[left]%2;
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return nice(nums,k)- nice(nums,k-1);
        
    }
}