//Time Complexity: O(N*N)
//Space Complexity: O(Height of the tree)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val;}
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;
        for(int x = 0; x < inorder.length; x++)
        {
            if(inorder[x] == root.val)
            {
                index = x;
                break;
            }
        }

        int[] preleft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preright = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);

        return root;

    }
}