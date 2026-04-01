class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int k = 0; k <= 31; k++){
            int ones = 0;
            int zeros = 0;
            int temp = (1<<k);
            for(int num : nums){
                if((num & temp) == 0) zeros++;
                else ones++;
            }
            if(ones % 3 != 0){
                result = ( result | temp );
            }
        }
        return result;
    }
}