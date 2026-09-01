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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i : to_delete) set.add(i);
        helper(root, set, list);

        if(!set.contains(root.val)) list.add(root);
        return list;
    }
    private TreeNode helper(TreeNode root, Set<Integer> st, List<TreeNode> list){
        if(root == null) return null;
        root.left = helper(root.left, st, list);
        root.right = helper(root.right, st, list);
        if(st.contains(root.val)){
            if(root.left != null) list.add(root.left);
            if(root.right != null) list.add(root.right);
            return null;
        }
        else{
            return root;
        }
    }
}