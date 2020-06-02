package coding.graph;

import java.util.Arrays;

public class ContructBSTreeFromPreOrder {
	static int pIndex = 0;
	public static TreeNode constructBSTWithoutInorder(int[] preOrder, int low, int high) {
		if(pIndex >= preOrder.length || low > high) return null;
		TreeNode ptr = new TreeNode(preOrder[pIndex]);
		pIndex++;    
		if(low == high)
			return ptr;
		int i=0;
		for(i=low; i<=high; i++) {
			if(ptr.data > preOrder[i])
				break;
		}
		ptr.left = constructBSTWithoutInorder(preOrder, low+1, i-1);
		ptr.right = constructBSTWithoutInorder(preOrder, i, high);
		
		return ptr;
	}
	public static TreeNode constructBST(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
		if(pIndex >= preOrder.length) return null;
		if(inStart > inEnd) return null;
		TreeNode ptr = new TreeNode(preOrder[pIndex++]);
		if(inStart == inEnd) {
			return ptr;
		}
		int rootIndex = findRootIndex(inOrder, ptr.data, inStart, inEnd);
		ptr.left = constructBST(preOrder, inOrder, inStart, rootIndex-1);
		ptr.right = constructBST(preOrder, inOrder, rootIndex+1, inEnd);
		return ptr;
	}

	private static int findRootIndex(int[] inOrder, int rootElement, int left, int right) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(inOrder[mid] == rootElement) return mid;
			else if(inOrder[mid] < rootElement)
				left = mid + 1;
			else right = mid-1;
		}
		return -1;
	}
	public static void preOrder(TreeNode ptr) {
		if(ptr != null) {
			System.out.println(ptr.data);
			preOrder(ptr.left);
			preOrder(ptr.right);
		}
	}
	public static void main(String[] args) {
		int preOrder[] = new int[] {3,9,20,15,7};
		int inOrder[] = new int[] {9,3,15,20,7};
		Arrays.sort(inOrder);
		TreeNode root = null;
		TreeNode node = constructBST(preOrder, inOrder, 0, inOrder.length);
		preOrder(node);
	}

}
