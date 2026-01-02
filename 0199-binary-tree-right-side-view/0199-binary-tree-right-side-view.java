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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root,ans,0);
        // if(root==null){return ans;}
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode p = q.remove();
        //         if(i==size-1){
        //             ans.add(p.val);
        //         }
        //         if(p.left != null) q.offer(p.left);
        //         if(p.right != null) q.offer(p.right);
        //     }
        // }
        return ans;
    }
    public void rightView(TreeNode curr, List<Integer> ans, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == ans.size()) ans.add(curr.val);
        
        rightView(curr.right, ans, currDepth + 1);
        rightView(curr.left, ans, currDepth + 1);
    }
}