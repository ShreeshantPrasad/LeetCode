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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int max= Integer.MIN_VALUE;
        int resLev = 1;
        int currLev = 1;
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            //Traversal
            while(n-- >0){
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            if(sum>max){
                max = sum;
                resLev = currLev;
            }
            currLev++; 
        }
        return resLev;
    }
}