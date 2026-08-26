class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        Arrays.sort(strs);
        String left=strs[0];
        String right=strs[strs.length-1];
        for(int i =0;i<left.length();i++){
            if(left.charAt(i)==right.charAt(i)){
                ans+=left.charAt(i);
            }
            else{
                break;
            }
        }
        
 return ans;
        
    }
}