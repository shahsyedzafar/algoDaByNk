package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {
	
	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		//TreeNode root = new TreeNode(2);
		//bt.root = root;
		bt.root = bt.insert(bt.root, 12);
		bt.root = bt.insert(bt.root, 3);
		bt.root = bt.insert(bt.root, 4);
		bt.root = bt.insert(bt.root, 15);
		bt.root = bt.insert(bt.root, 6);
		
		//pre-order tree walk
		System.out.println("Pre-order tree walk recursive");
		bt.preOrder(bt.root);
		//post-order tree walk
		System.out.println("\nPost-order tree walk recursive");
		bt.postOrder(bt.root);
		
		System.out.println("\nIn-order tree walk recursive");
		//in-order tree-wald
		bt.inOrder(bt.root);
		
		System.out.println("\nInorder treewalk iterative");
		System.out.println(bt.inOrder_iterative(bt.root));
		
		System.out.println("\nFinding Max");
		System.out.println(bt.findMax(bt.root));
		
		System.out.println("\nFinding max recursive");
		System.out.println(bt.findMax_recursive(bt.root));
		
		//Find an element
		System.out.println("\nFinding root with value 142 and 6");
		System.out.println(bt.find_iterative(bt.root, 142));
		System.out.println(bt.find_recursive(bt.root, 6));
		
		System.out.println("\nSize of binary tree with recursion is");
		System.out.println(bt.findSize(bt.root));
		
		System.out.println("\nSize of BinaryTree without recursion");
		System.out.println(bt.findSizeWithoutRecursion(bt));
		
		System.out.println("\nDeleting a binary tree");
		bt.deleteTree(bt.root);
		
		bt.root = bt.insert(bt.root, 12);
		bt.root = bt.insert(bt.root, 3);
		bt.root = bt.insert(bt.root, 4);
		bt.root = bt.insert(bt.root, 15);
		bt.root = bt.insert(bt.root, 6);
		
		//pre-order tree walk
		System.out.println("\nPre-order tree walk recursive");
		bt.preOrder(bt.root);
		
		System.out.println("\nPrinting level order in reverse");
		bt.levelOrderReverse(bt.root);
		
		System.out.println("\nPrinting height of binary Tree");
		System.out.println(bt.findHeight(bt.root));
			
		System.out.println("\nFinding minimum depth of tree");
		System.out.println(bt.minimDepth(bt.root));
		
		
		
		
	}
	

		
		
		
		
		
		
		
		
		
		

	

	/* public void insert(int data)
     {
         root = insert(root, data);
     }
	 */
	
	private int minimDepth(TreeNode root) {
		// TODO Auto-generated method stub
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 0;
		while(!q.isEmpty()) {
			TreeNode currentNode = q.poll();
			if(currentNode!=null) {
				
				if(currentNode.left==null && currentNode.right == null) {
					return count;
				}
				if(currentNode.left!=null) {
					q.offer(currentNode.left);
				}
				if(currentNode.right!=null) {
					q.offer(currentNode.right);
				}
				
			} else {
				if(!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
			
			
		}
		
		
		
		return count;
	}

	public int findMinHeight(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while(!q.isEmpty()) {
			TreeNode current = q.poll();
			if(current != null) {
				
				if(current.left==null || current.right==null) {
					
				}
				if(current.left!=null) {
					q.offer(current.left);
				}
				if(current.right != null) {
					q.offer(current.right);
				}
			} else {
				if(!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
			
		}
		
		
		
		return 0;
		
		
		
	}
	
	
	public int findHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
			int l = findHeight(root.left);
			int r = findHeight(root.right);
			return (l>r)?l+1:r+1;
		
		
		
	}
	
	public void deleteTree(TreeNode root) {
		this.root = null;
		//taken care by garbage collection
	}
	
	public void levelOrderReverse(TreeNode root) {
		//Stack<ArrayList> s = new Stack<ArrayList>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<Integer> s = new Stack<Integer>();
		q.offer(root);

		
		while(!q.isEmpty()) {
			TreeNode x = q.poll();
			if(x.right!=null) {
				q.offer(x.right);
			}
			if(x.left!=null) {
				q.offer(x.left);
			}
			
			
			s.push(x.value);
		}
		
		
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
	
	
	public int findSizeWithoutRecursion(BinaryTree bt) {
		TreeNode x = bt.root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(x);
		int count = 1;
		while(!q.isEmpty()) {
			TreeNode p = q.poll();
			TreeNode left = p.left;
			TreeNode right = p.right;
			if(left!=null) {
				q.offer(left);
				count++;
			}
			if(right!=null) {
				q.offer(right);
				count++;
			}
			
			
		}
		return count;
		
	}
	 
     // Function to insert data recursively 
     private TreeNode insert_recursive(TreeNode node, int data)
     {
         if (node == null)
             node = new TreeNode(data);
         else
         {
             if (node.right == null)
                 node.right = insert(node.right, data);
             else
                 node.left = insert(node.left, data);             
         }
         return node;
     }     
	
     
	
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}	
		else {
			return;
		}
	}
	
	public void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
			
		}	
		else {
			return;
		}
	}
	
	
	public void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value + " ");	
		}	
		else {
			return;
		}
	}
	
	public ArrayList<Integer> inOrder_iterative(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		boolean done = false;
		while(!done) {
			if(curr!=null) {
				s.push(curr);
				curr = curr.left;
				
			} else {
				if(s.isEmpty()) {
					done = true;
				} else {
					
					curr = s.pop();
					res.add(curr.value);
					curr = curr.right;
				}
				
				
			}
		}
		
		return res;
		
		
	}
	
	

	//Prob 1: Finding max
	public int findMax(TreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int l = findMax(root.left);
		int r = findMax(root.right);
		int rootval = root.value;
		int max = helperMax(l,r,rootval);
		return max;
		
	}

	public int helperMax(int a, int b, int c) {
		if(a>=b && a>=c) {
			return a;
		} else if(b>=c && b>=a) {
			return b;
		}
		return c;
	}
	
	
	//Level order traversal and maitain a queue
	public int findMax_recursive(TreeNode root) {
		Queue<TreeNode> res = new LinkedList<TreeNode>();
		res.offer(root);
		int max = Integer.MIN_VALUE;
		
		
		while(!res.isEmpty()) {
			TreeNode temp = res.poll();
			
			if(temp.value>max) {
				max = temp.value;
			}
			
			if(temp!=null) {
				if(temp.left!=null) {
					res.offer(temp.left);
				}
				if(temp.right!=null) {
					res.offer(temp.right);
				}
			}
			
		}
				
		return max;
			
	}
	
	
	
	public boolean find_iterative(TreeNode root, int data) {
		Queue<TreeNode> res = new LinkedList<TreeNode>();
		res.offer(root);
		int max = Integer.MIN_VALUE;
		
		
		while(!res.isEmpty()) {
			TreeNode temp = res.poll();
			
			if(temp.value == data) {
				max = temp.value;
				return true;
			}
			
			if(temp!=null) {
				if(temp.left!=null) {
					res.offer(temp.left);
				}
				if(temp.right!=null) {
					res.offer(temp.right);
				}
			}
			
		}
				
		return false;			
	}
	
	
	public boolean find_recursive(TreeNode root, int data) {
	
		if(root!=null) {
			if(data == root.value) {
				return true;
			} else {	
				if(find_recursive(root.left, data) || find_recursive(root.right, data)) {
					return true;
				} else {
					return false;
				}
			}
		} 
		return false;		
	}
	
	public TreeNode insert(TreeNode root, int data) {
		
		TreeNode x = new TreeNode(data);
		
		
		if(root == null) {
			root = x;
		} else {
			Queue<TreeNode> res = new LinkedList<TreeNode>();
			res.offer(root);
			
			while(!res.isEmpty()) {
				TreeNode temp = res.poll();
				if(temp!=null) {
					if(temp.left != null) {
						//temp = temp.left;
						res.offer(temp.left);
					} else {
						temp.left = x;
						return root;
						
					}
					if(temp.right!=null) {
						res.offer(temp.right);
					} else {
						temp.right = x;
						return root;
					}
					
				}			
				
			}
					
		}
					
		return root;	
	}
	
	
	//number of nodes in tree
	public int findSize(TreeNode root) {
		
		int leftCount = root.left==null?0:findSize(root.left);
		int rightCount = root.right==null?0:findSize(root.right);
		
		return leftCount+rightCount+1;
		
	}
	
	public int findSize_recursive(TreeNode root) {
		if(root != null) {
			int count = 1;
			int leftcount = 0, rightcount = 0;
			
			while(root.left!=null) {
				leftcount++;
				root = root.left;
			}
			
			
		}
		return 0;
		
	}
	
}
