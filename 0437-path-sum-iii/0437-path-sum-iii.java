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
    int cnt;
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        help(root,targetSum);
        return cnt;
    }
    private void help(TreeNode root, int target){
        if(root == null) return;

        solve(root,0L,target);
        help(root.left, target);
        help(root.right, target);
    }
    private void solve(TreeNode root, long sum, int target){
        if(root == null) return;
        sum += (long) root.val;
        if(sum == (long)target) cnt++;
        solve(root.left,sum,target);
        solve(root.right,sum,target);
    }
}