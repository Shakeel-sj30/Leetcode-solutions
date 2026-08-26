class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int [] maps= new int[256];
        int [] mapt = new int [256];
        for(int i =0;i<s.length();i++){
            char a = s.charAt(i);
            char b =t.charAt(i);
            if(maps[a]!=mapt[b]){
               return false;
            }
            maps[a]=i+1;
            mapt[b]=i+1;
        }
        return true;
    }
}