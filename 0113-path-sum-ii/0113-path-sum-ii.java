/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        help(root,0,targetSum,list);
        return res;
    }
    private void help(TreeNode root, int sum, int targetSum, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        sum += root.val;
        if(root.left==null && root.right==null && sum == targetSum){
            res.add(new ArrayList<>(list));
        }

        help(root.left,sum,targetSum,list);
        help(root.right,sum,targetSum,list);
        list.remove(list.size()-1);
    }
}