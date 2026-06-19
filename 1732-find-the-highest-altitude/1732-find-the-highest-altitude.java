class Solution {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int cur =0;
        for(int i=0;i<gain.length;i++){
            cur = cur + gain[i];
            highest = Math.max(cur,highest);
        }
        return highest;
    }
}