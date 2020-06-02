package coding.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;

public class BinarySearchTree {
	public TreeNode insertNode(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) {
			root = node;
		}else {
			if(val > root.data) {
				root.right = insertNode(root.right, val);
			}else {
				root.left = insertNode(root.left, val);
			}
		}
		return root;
	}
	
	public boolean search(TreeNode root, int val) {
		if(root == null) return false;
		if(root.data == val) return true;
		if(root.data <= val)
			return search(root.right, val);
		return search(root.left, val);
	}
	
	public void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print("-> "+root.data);
		inorder(root.right);
	}
	
	public static void levelOrderTraversal(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList();
		Queue<TreeNode> reverseQueue = new LinkedList();
		queue.add(root);
		boolean turn = true;
		
		while(!queue.isEmpty() || !reverseQueue.isEmpty()) {
			if(turn) {
				int count = queue.size();
				while(count > 0) {
						TreeNode node = queue.remove();
						System.out.print("->"+node.data);
						if(node.right != null)
							reverseQueue.add(node.right);
						if(node.left != null)
							reverseQueue.add(node.left);
						count--;
				}
				turn = false;
		    }else {
		      int count = reverseQueue.size();
		      while(count > 0) {
		    	  TreeNode node = reverseQueue.remove();
					System.out.print("->"+node.data);
					if(node.left != null)
						queue.add(node.left);
					if(node.right != null)
						queue.add(node.right);
					count--;
		      }
		       turn = true;
		       
		    }
		}
		return;
	}
	
	public static void printPath(String path,TreeNode root, List<String> pathList) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			path+=Integer.toString(root.data);
			pathList.add(path);
		}
		else {
			printPath(path+ Integer.toString(root.data)+"->", root.left, pathList);
			printPath(path+ Integer.toString(root.data)+"->", root.right, pathList);
		}
		return;
	}
	public static void main(String [] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = null;
		root = bst.insertNode(root, 50);
		root = bst.insertNode(root, 20);
		root = bst.insertNode(root, 30);
		root = bst.insertNode(root, 40);
		root = bst.insertNode(root, 70);
		root = bst.insertNode(root, 60);
		root = bst.insertNode(root, 80);
		levelOrderTraversal(root);
		
		//bst.inorder(root);
		
		//List<String> pathList = new ArrayList<>();
		//printPath("", root, pathList);
		//System.out.println(pathList);
		//System.out.println("\n node is present in the Tree: "+bst.search(root, 81));
	}
}
