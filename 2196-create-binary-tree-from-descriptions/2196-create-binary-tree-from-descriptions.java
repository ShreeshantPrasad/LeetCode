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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();

        for(int [] arr : descriptions){
            int parent = arr[0];
            int child = arr[1];
            boolean isLeft = arr[2] == 1;

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            if(isLeft){
                map.get(parent).left = map.get(child);
            } else{
                map.get(parent).right = map.get(child);
            }
            childSet.add(child);
        }
        for(int [] arr : descriptions){
            int parent = arr[0];
            if(!childSet.contains(parent)){
                return map.get(parent);
            }
        }
        return null;
    }
}