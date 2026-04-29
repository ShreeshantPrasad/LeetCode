class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for(int i : piles){
            high = Math.max(high,i);
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(mid,h,piles)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean isPossible(int e, int h, int[] piles){
        long curr = 0;
        for(int i = 0; i < piles.length; i++){
            curr += (long) (piles[i]/e) + ((piles[i] % e == 0) ?  0 : 1);
        }
        return curr <= h;
    }
}