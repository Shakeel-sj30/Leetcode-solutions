class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> s = new ArrayList<>();
        int n = asteroids.length;
        for (int i =0;i<n;i++){
             
             if(asteroids[i]>0){
                s.add(asteroids[i]);
             }
             else{
              while (!s.isEmpty() && s.get(s.size() - 1) > 0 &&
                       s.get(s.size() - 1) < Math.abs(asteroids[i])){
                s.remove(s.size() - 1);}
                if((s.isEmpty()) || (s.get(s.size() - 1)<0)){
                    s.add(asteroids[i]);

                }
                else if (Math.abs(asteroids[i])== s.get(s.size() - 1)){
                    s.remove(s.size() - 1);

                }

              }
        }
        
        int[] arr = new int [s.size()];
        for(int i =0;i<s.size();i++){
            arr[i]=s.get(i);
        }
        return arr;
    }
}