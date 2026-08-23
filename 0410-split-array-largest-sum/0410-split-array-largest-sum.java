class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high =0;
        for(int i :nums){
            low= Math.max(i,low);
            high+=i;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(cansplit(nums,mid,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
    public boolean cansplit(int[]nums,int maxsum, int k ){
        int parts = 1;
        int currentsum =0;
        for(int n: nums){
            
            if(currentsum+n<=maxsum){
                currentsum+=n;
            }
            else{
                parts++;
                currentsum=n;
            }
        }
        return parts<=k;
    }
}