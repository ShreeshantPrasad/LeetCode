class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long val = (long)mass;
        Arrays.sort(asteroids);
        for(int i : asteroids ){
            if(val < i){
                return false;
            }
            val += i;
        }
        return true;
    }
}