package LeetCodeExercise;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preLen-1,map,0,inLen-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pIndex = map.get(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, preLeft + pIndex - inLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, preLeft + pIndex - inLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }
}
