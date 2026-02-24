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
    TreeNode target;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root,null);
        buildParentMap(root,null,map,start);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);
        int dis = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent = map.get(curr);
                if(parent != null && !vis.contains(parent)){
                    vis.add(parent);
                    q.offer(parent);
                }
            }
            dis++;
        }
        return dis-1;

        
    }
    public void buildParentMap(TreeNode node, TreeNode parent, HashMap<TreeNode,TreeNode> map,int start){
        if(node == null) return;
        if(node.val == start) target = node;
        map.put(node,parent);
        buildParentMap(node.left,node,map,start);
        buildParentMap(node.right,node,map,start);
    }
}