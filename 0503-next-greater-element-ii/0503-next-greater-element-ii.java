class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        
        int n = nums.length;
        int []res = new int [n];
        for(int i = 2*(n-1);i>=0;i--){
            int ind= i%n;
            while((!s.isEmpty()) &&(s.peek()<=nums[ind])){
                s.pop();
            }
            if(i<n){
                if(s.isEmpty()){
                    res[ind]=-1;
                }
                else{
                    res[ind]= s.peek();
                }
            }
            s.push(nums[ind]);
        }
        return res;

    }
}