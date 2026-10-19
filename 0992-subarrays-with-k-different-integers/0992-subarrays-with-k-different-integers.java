class Solution {
    private int subarr(int[] nums, int k) {
        int left=0;int count=0;
        Map<Integer,Integer> map =new HashMap<>();
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
        
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return  subarr(nums,k)- subarr(nums,k-1);
    }
}