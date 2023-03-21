package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 144. Binary Tree Preorder Traversal
 */
public class No144 {
    private static TreeNode thirdNode = new TreeNode(3);
    private static TreeNode secondNode = new TreeNode(2, thirdNode, null);
    private static TreeNode root = new TreeNode(1, null, secondNode);

    public static void main(String[] args) {
        List<Integer> answer = preorderTraversal(root);
        System.out.println(answer);
    }
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if (root == null) { return answer; }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            answer.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return answer;
    }

    private static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorder(root, answer);
        return answer;
    }
    private static void preorder(TreeNode root, List<Integer> answer) {
        if (root == null) return;
        answer.add(root.val);
        preorder(root.left, answer);
        preorder(root.right, answer);
    }
}
