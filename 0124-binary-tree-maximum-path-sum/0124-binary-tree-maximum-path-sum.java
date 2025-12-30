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
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        solve(root,sum);
        return sum[0];
    }
    public int solve(TreeNode root, int[] max){
        if(root==null) return 0;

        int lSum = Math.max(0, solve(root.left,max));        
        int rSum = Math.max(0, solve(root.right,max));

        max[0] = Math.max(max[0],lSum + rSum + root.val);
        return Math.max(lSum,rSum) + root.val;
    }
}