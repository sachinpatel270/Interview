/* List of Questions are in order of:

1-Convert a given array to a binary tree with minimum height
2-Check that whether given binary tree is binary search tree
3-

*/



public class TreeNode {

	  int value;
	  TreeNode left;
	  TreeNode right;
	  
	  	TreeNode(int val){
	  		
	  		this.value = val;
	  		this.left = null;
	  		this.right = null;
	  		
	  	}
	
	/* Question 1: Convert a given array to a binary tree with minimum height */
	
	public static TreeNode arrayToTree(int[] ar) {

		return arrayToTree(ar, 0, ar.length - 1);
	}

	public static TreeNode arrayToTree(int[] ar, int L, int R) {

		if (L > R)
			return null;

		int mid = (L + R) / 2;
                TreeNode root = new TreeNode(ar[mid]); 
		root.left = arrayToTree(ar, L, mid - 1);
		root.right = arrayToTree(ar, mid + 1, R);

		return root;
	}
	
	/*Check that whether given binary tree is binary search tree*/
	
	public static boolean isValidBST(TreeNode root) {

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, int left, int right) {

		if (root == null)
			return true;
		if (root.value <= left || root.value > right)
			return false;
		
		return isValidBST(root.left, left, root.value)
				&& isValidBST(root.right, root.value, right);

	}
	
	
	}
