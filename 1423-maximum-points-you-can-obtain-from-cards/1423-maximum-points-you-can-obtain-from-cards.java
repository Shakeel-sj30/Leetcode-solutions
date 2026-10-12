class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxsum=0;
        int sum=0;
        int n =cardPoints.length;
        for(int i =0;i<k;i++){
            sum+=cardPoints[i];
        }
        maxsum=sum;
        
        for(int i =0;i<k;i++){
            sum-= cardPoints[k-1-i];
            sum+=cardPoints[n-1-i];
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
}