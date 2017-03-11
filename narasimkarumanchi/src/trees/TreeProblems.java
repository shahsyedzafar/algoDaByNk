package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeProblems {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(11);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		TreeProblems d = new TreeProblems();
		System.out.println(d.diameter(root));
		
		System.out.println(d.mywidth(root));
		
		System.out.println("\nMax LevelSum of tree: " + d.max_levelSum(root));
		
		System.out.println("\nPrinting all paths of tree");
		//List<List<Integer>>  al = new ArrayList<List<Integer>>();
		
		int[] path = new int[256];
		
		
		
		d.printPaths(root,path,0);
		
		System.out.println("\nChecking path with sum 15");
		System.out.println(d.checkPathSum(root, 24, 0));
		
		System.out.println("\nPrint Mirror of Binary Tree");
		TreeNode mroot = null;
		
		
		BinaryTree bt = new BinaryTree();
		System.out.println("\nInorder tree walk");
		bt.inOrder(root);
		
		TreeProblems tp = new TreeProblems();
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		
		mroot = tp.printMirrorOfBT(root);
		System.out.println("\nInorder tree walk of mirror tree");
		bt.inOrder(mroot);
		
		//bt.areMirrorTrees(root, mroot);
		
		
		
	}
	
	

	public void printPaths(TreeNode root, int[] path, int pathlen) {
		
		if(root == null) {
			return;
		}
		
		path[pathlen] = root.value;
		pathlen++;
		
		if(root.left == null && root.right == null) {
			printArray(path, pathlen);
			//return;
		}	
		printPaths(root.left, path, pathlen);
		printPaths(root.right, path, pathlen);		
	}
	
	
	
	public TreeNode printMirrorOfBT(TreeNode root) {
		
	if(root != null) {
		
		TreeNode temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		printMirrorOfBT(root.left);
		printMirrorOfBT(root.right);
		
		
	}

	return root;	
		
		
	}
	
	public void swap(TreeNode root) {
		TreeNode temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	
	public boolean checkPathSum(TreeNode root, int key, int sum) {
		
		if(root == null) {
			return false;
		}
		
		if(root.left == null && root.right == null) {
			sum += root.value;
			if(sum == key) {
				return true;
			} else 
			return false;
		}
		
		int x = sum+root.value;
		if(checkPathSum(root.left, key, x) ||
		checkPathSum(root.right, key, x)) {
			return true;
		}
		
		return false;
	}
	
	public void printArray(int[] path, int len) {
		
		for(int i=0;i<len;i++) {
			System.out.print(path[i] + ",");
		
		}
		System.out.println(" ");
	}

	public int diameter(TreeNode root) {
		
		if(root != null) {
			
			int left_height = getHeight(root.left);
			int right_height  = getHeight(root.right);
			
			int left_diameter = diameter(root.left);
			int right_diameter = diameter(root.right);
			
			return Math.max(left_height+right_height+1, Math.max(left_diameter, right_diameter));
			
		}
		return 0;
		
		
		
		
	}
	
	public int getHeight(TreeNode root) {
		if(root!=null) {
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
		return 0;
	}
	
	public int width(TreeNode root) {
		int max = 0;
		int height = getHeight(root);
		for(int k=0;k<=height;k++) {
			int temp = width(root, k);
			if(temp>max) {
				max = temp;
			}
		}
		
		return max;
	}

	public int width(TreeNode root, int depth) {
		
		if(root == null) {
			return 0;
		} else {
			if(depth == 0)
				return 1;
			else 
				return width(root.left, depth-1) + width(root.right, depth-1);
		}
		
		
	}
	
	//do level order traversal and count nodes at each level
	
	public int mywidth(TreeNode root){
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> l = new ArrayList<Integer>();
		if(root != null) {
			q.offer(root);
			q.offer(null);
			l.add(1);
			
		}
		
		int count = 0;
				
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr!=null) {
				
				if(curr.left!=null) {
					q.offer(curr.left);
					count++;
				}
				if(curr.right!=null) {
					q.offer(curr.right);
					count++;
				}
			} else {
				if(!q.isEmpty()) {
					q.offer(null);
					l.add(count);
					count = 0;
				}
			}
		}
		
		System.out.println(l);
		//max of list will be th width 
		
		return 0;
		
	}
	
	
	
	public int max_levelSum(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		int currSum = 0;
		int maxSum = 0;
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null){
				
				if(curr.left!=null) {
					q.offer(curr.left);
					currSum += curr.left.value;
				}
				
				if(curr.right!=null) {
					q.offer(curr.right);
					currSum += curr.right.value;
				}
			} else {
				if(!q.isEmpty()) {
					q.offer(null);
					
					System.out.println("curr sum: " + currSum);
					if(currSum>maxSum) {
						
						maxSum = currSum;
					}
					
					currSum = 0;
					
				}
			}
		}
		return maxSum;
		
	}

	
	
}
