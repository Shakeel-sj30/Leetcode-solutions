class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxleft=0;
        int maxright=0;
        int left=0;
        int right=n-1;
        int total =0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxleft){
                    maxleft= height[left];
                }
                else{
                    total+= maxleft-height[left];
                }
            
            left++;
            }
            else{
                if(height[right]>=maxright){
                    maxright= height[right];
                }
                else{
                    total+= maxright-height[right];
                }
              right--;
            }
            
        }
        return total;
    }
}