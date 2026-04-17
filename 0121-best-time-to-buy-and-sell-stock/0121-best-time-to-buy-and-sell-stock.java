class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for(int i : prices){
            int currProf =0;
            if(i < buy){
                buy = i;
            }else{
                currProf = i - buy;
            }
            max = Math.max(max,currProf);
        }
        return max;
    }
}