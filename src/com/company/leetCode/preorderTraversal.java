/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode thisRoot = stack.pop();
            list.add(thisRoot.val);
            if(thisRoot.right != null)
                stack.push(thisRoot.right);
            if(thisRoot.left != null)
                stack.push(thisRoot.left);
        }
        return list;
    }
}
*/
