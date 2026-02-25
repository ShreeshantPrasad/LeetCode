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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return help(preorder,0,inorder.length-1,map);
    }
    private TreeNode help(int[] preorder, int start, int end, HashMap<Integer,Integer> map){
        if(start > end) return null;
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);
        int inIdx = map.get(rootVal);
        root.left = help(preorder,start,inIdx-1,map);
        root.right = help(preorder,inIdx+1,end,map);
        return root; 
    }
}