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
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null){
            return root1==root2;
        }
        boolean left=isSameTree(root1.left,root2.left);
        boolean right=isSameTree(root1.right,root2.right);
        return left && right && root1.val==root2.val;
    }
}