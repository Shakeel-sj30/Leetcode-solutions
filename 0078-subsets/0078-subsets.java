class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subset = 1<<n;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i =0;i<subset;i++){
            List<Integer> sub =new ArrayList<>();

            for(int j =0;j<n;j++){
                if((i &(1<<j))!=0){
                    sub.add(nums[j]);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}