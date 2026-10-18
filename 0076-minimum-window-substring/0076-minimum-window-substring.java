class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n =t.length();
        int count=0;
        int minlen=(int) 1e9;
        int sind=-1;
        int r=0;int l=0;
        int [] hash = new int [256];
        for(int i =0;i<n;i++){
            hash[t.charAt(i)]++;
        }
        while(r<m){
            if(hash[s.charAt(r)]>0){
                count++;
            }
            hash[s.charAt(r)]--;
            while(count==n){
                 hash[s.charAt(l)]++;
                 
                 if(r-l+1<minlen){
                    minlen= r-l+1;
                    sind=l;
                 }
                 if(hash[s.charAt(l)]>0){
                    count--;
                 }
                 l++;


            }
            r++;
        }
        return sind==-1? "":s.substring(sind, sind + minlen);
        
    }
}