class Solution {
    public void helper(List<List<Integer>>ans, List<Integer> temp, int[] nums,int i,int target,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        else if(sum>target || i>=nums.length) return;
        else{
            helper(ans,temp,nums,i+1,target,sum);

            temp.add(nums[i]);
            helper(ans,temp,nums,i,target,sum+nums[i]);
            temp.remove(temp.size()-1);
            return;
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),nums,0,target,0);
        return ans;
    }
}