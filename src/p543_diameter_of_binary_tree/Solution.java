package p543_diameter_of_binary_tree;


class TreeNode {
     private int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getDiameter(root, 0);
        return maxDiameter-1;
    }

    private int getDiameter(TreeNode root, int max) {
        int hCrossDiameter, crossDiameter;
        if (root.left != null && root.right != null) {
            int left = getDiameter(root.left, max), right = getDiameter(root.right, max);
            hCrossDiameter = Math.max(left, right) + 1;
            crossDiameter = left + right + 1;
        } else if (root.left != null) {
            crossDiameter = hCrossDiameter = getDiameter(root.left, max) + 1;
        } else if (root.right != null) {
            crossDiameter = hCrossDiameter = getDiameter(root.right, max) + 1;
        } else {
            crossDiameter = hCrossDiameter = 1;
        }
        if (crossDiameter > maxDiameter) maxDiameter = crossDiameter;
        return hCrossDiameter;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(new TreeNode(1)));
    }
}