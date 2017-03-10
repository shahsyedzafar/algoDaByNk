package trees;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		
		this.value = val;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
		
	}
}
