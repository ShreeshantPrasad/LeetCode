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
    int maxSteps;
    public int longestZigZag(TreeNode root) {
        maxSteps = 0;
        solve(root, 0, true);
        solve(root, 0, false);
        return maxSteps;
    }
    private void solve(TreeNode root, int steps, boolean goLeft){
        if(root == null) return;
        maxSteps = Math.max(maxSteps, steps);
        if(goLeft == true){
            solve(root.left, steps+1, false);
            solve(root.right, 1, true);
        }
        else{
            solve(root.right, steps+1, true);
            solve(root.left, 1, false);
        }   
    }
}