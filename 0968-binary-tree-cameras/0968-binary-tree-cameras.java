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
    int camera;
    public int minCameraCover(TreeNode root) {
        camera = 0;
        if(helper(root) == 0){
            camera++;
            return camera;
        }
        return camera;
    }
    public int helper(TreeNode node){
        if(node == null) return 2;
        int left = helper(node.left);
        int right = helper(node.right);
        if(left == 0 || right == 0){
            camera++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 2;
        }
        return 0;
    }
}