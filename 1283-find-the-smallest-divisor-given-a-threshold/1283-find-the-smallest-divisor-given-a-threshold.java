class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high = 0;
        
        for(int i:nums){
            high=Math.max(i,high);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            int sum=0;
            
            for(int a :nums){
                sum+= (a+mid-1)/mid;}
                if(sum<=threshold){
                    high=mid-1;

            }
            else{
                low=mid+1;
            }
            

            }
        
        return low ;
        
    }
}