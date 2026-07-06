class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),k,n,0,1);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> temp, int k, int n, int sum, int i){
        if(k==0 && sum==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k==0 || sum>n) return;
        if(i>9) return;
        temp.add(i);
        sum += i;
        helper(ans,temp,k-1,n,sum,i+1);
        sum -= i;
        temp.remove(temp.size()-1);
        helper(ans,temp,k,n,sum,i+1);
        return;
    }
}