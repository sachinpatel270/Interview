/* List of Questions are in order of:

Question 1: Convert a given array to a binary tree with minimum height
Question 2: Check that whether given binary tree is binary search tree
Question 3: Print all the path from root to lead node 

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
	
	/* Question 1: 
	Convert a given array to a binary tree with minimum height 
	*/
	
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
	
	/* Question 2: 
	Check that whether given binary tree is binary search tree
	*/
	
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
	
	/*Question 3:
	 Print all the path from root to leaf (printRootToLeaf)
	 */
	
	public static void printRootToLeaf(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		printRootToLeaf(root, list);
	}

	public static void printRootToLeaf(TreeNode root, ArrayList<Integer> path) {

		if (root == null)
			return;
		path.add(root.value);

		// check whether it is a leaf node, if yes, print the path
		if (root.right == null && root.left == null) {
			System.out.println(path);
			return;
		}

		printRootToLeaf(root.left, new ArrayList<Integer>(path));
		printRootToLeaf(root.right, new ArrayList<Integer>(path));

	}
	
}
