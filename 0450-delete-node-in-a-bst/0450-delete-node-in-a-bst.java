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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val > key){
            root.left =  deleteNode(root.left, key);
        } 
        else if(root.val < key){
            root.right =  deleteNode(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            else{
                TreeNode nextNode = getNext(root, key);
                root.val = nextNode.val;
                root.right = deleteNode(root.right, nextNode.val);
            }
        }
        return root;
    }
    private TreeNode getNext(TreeNode root, int val){
        root = root.right;
        while(root != null && root.left != null) root = root.left;
        return root;
    }
}