class Solution {
    public int numberOfSubstrings(String s) {
        int [] hash = {-1,-1,-1};
        int count=0;
        for(int i =0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                count += Math.min(Math.min(hash[0], hash[1]), hash[2]) + 1;
            }
        }
        return count;
    }
}