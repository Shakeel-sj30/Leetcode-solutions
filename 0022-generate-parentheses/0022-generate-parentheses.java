class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,0,0,"",n);
        return ans;
        
    }
    private void backtrack(List<String> ans,int open,int close,String current,int n){
        
        if(current.length()==2*n){
            ans.add(current);
            return;
        }
        if (open<n){
            backtrack(ans,open+1,close, current +'(',n);
        }
        if (close<open){
            backtrack(ans ,open,close+1,current +')',n);
        }

    }
}