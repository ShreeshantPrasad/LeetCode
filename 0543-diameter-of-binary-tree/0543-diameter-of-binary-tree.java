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
    public int diameterOfBinaryTree(TreeNode root) {
//        int maxx = 1; // Variable pass by reference nhi hota islia array bnana pdega
        int [] maxx = new int[1];   
        solve(root,maxx);
        return maxx[0];
    }
    public int solve(TreeNode root, int [] maxx){
        if(root == null) return 0;

        int lH = solve(root.left,maxx);
        int rH = solve(root.right,maxx);
        maxx[0] = Math.max(maxx[0],lH+rH);
        
        return 1 + Math.max(lH,rH);
    }
}