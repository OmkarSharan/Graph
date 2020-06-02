package coding.graph;

import java.util.Stack;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
	//1-4, 6-12, 16-18
	//3-5, 5-8, 10-12
	public void inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(true) {
			if(stack.isEmpty()) break;
			while(stack.peek().left != null)
				stack.push(stack.peek().left);
			TreeNode node = stack.pop();
			System.out.println(node.data);
			if(node.right!= null)
				stack.push(node.right);
				
			
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		
	}
}
