class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high =0;
        for(int i :weights){
            low=Math.max(i,low);
            high=high+i;
    }
        while(low<=high){
            int mid=low+(high-low)/2;
            int reqdays=1;
            int sum=0;
            for(int a :weights){
                if(sum+a>mid){
                    reqdays++;
                    sum=a;
                }
                else{
                    sum+=a;
                }

            }
            if(reqdays<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
        return low;
    }
}