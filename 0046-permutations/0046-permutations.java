class Solution {
    public void help(int []nums, List<List<Integer>> ans, ArrayList<Integer> temp, boolean[] isVisited ){
        int n=nums.length;
        if(temp.size()==n){
            ArrayList<Integer> result = new ArrayList<>(temp);
            ans.add(result);
            return;
        }
        for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            isVisited[i]=true;
            temp.add(nums[i]);
            help(nums,ans,temp,isVisited);
            temp.remove(temp.size()-1);
            isVisited[i]=false;

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        help(nums,ans,new ArrayList<Integer>(),isVisited);
        return ans;
    }
}