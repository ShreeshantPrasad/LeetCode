class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
            if(nums[i]<small) small = nums[i];
            if(nums[i]>large) large = nums[i]; 
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= small;i<= large;i++ ){
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}