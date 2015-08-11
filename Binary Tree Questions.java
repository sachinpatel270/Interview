/* List of Questions:

Question 1: Convert a given array to a binary tree with minimum height.
Question 2: Check that whether given binary tree is binary search tree.
Question 3: Print all the path from root to lead node. 
Question 4: Find lowest common Ancestor of a given two node. 
Question 5: Fint the nth number in Binary Search Tree(BST) when the elements of BST are sorted.
Question 6: Print the path which is add up to given target sum (path is starting from root).
Question 7: Check whether there exist a root to leaf path such that sum of this path is equal to given number.
Question 8: Given two binary trees, return true if they are structurally identical(both values and structure).
Question 9: Find the diameter of the given tree. i.e. maximum distance between any two leaf nodes. 
Question 10: Print all the sum from root to leaf node in binary tree.

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
	
	/* Question 4:
	Find lowest common ancestor of a given two node. (LCA())
	*/
	public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {

		if (root == null)
			return null;

		if (root == n1 || root == n2)
			return root;

		TreeNode l = LCA(root.left, n1, n2);
		TreeNode r = LCA(root.right, n1, n2);

		if (l != null && r == null)
			return l;
		if (l == null && r != null)
			return r;
		if (l != null && r != null)
			return root;
		
		return null;

	}
	
	/* Question 5: 
	Return the nth number in Binary Search Tree(BST) when the elements of BST are sorted.
	*/
	static int count = 0; // We just set it to be zero once here

	public static int nthLargestElementInBST(TreeNode root, int n) {

		if (root == null)
			return 0;
		else {
			int l = nthLargestElementInBST(root.left, n);
			++count;
			if (count == n)
				return root.value;
			int r = nthLargestElementInBST(root.right, n);

			return l + r;
		}

	}

	/* Question 6:
	Print the path which is add up to given target sum (path is starting from root)
	*/	
	public static void printPathTargetSum(TreeNode root, int target) {

	ArrayList<Integer> path = new ArrayList<Integer>();
	int sum = 0; // sum is initialized here

	printPathTargetSum(root, target, path, sum);

	}

	public static void printPathTargetSum(TreeNode root, int target,
			ArrayList<Integer> path, int sum) {

		if (root == null)
			return;
		else {
			path.add(root.value);
			sum += root.value;
			if (sum == target)
				System.out.print(path);
			printPathTargetSum(root.left, target, new ArrayList(path), sum);
			printPathTargetSum(root.right, target, new ArrayList(path), sum);
		}

	}
	
	/*Question 7:
	Check whether there exist a root to leaf path such that sum of this path is equal to given number
	*/
	
	public static boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}
		if (root.value > sum)
			return false;
		
		if (sum == root.value && (root.left == null && root.right == null))
			return true;
           
		boolean l =  hasPathSum(root.left, sum - root.value);
		boolean r = hasPathSum(root.right, sum - root.value);
		
		return l || r;
	}
	
	
	/* Question 8:
	Given two binary trees, return true if they are structurally identical.
	i.e they are made of nodes with the same values arranged in the same way.
	*/

	public static boolean isIdentical(TreeNode t1, TreeNode t2) {

		if ((t1 == null && t2 == null))
			return true;
		else if (t1 == null || t2 == null)
			return false;
		else if (t1.value != t2.value) {
			return false;
		} else

			return isIdentical(t1.left, t2.left)
					&& isIdentical(t1.right, t2.right);
	}
	
}

  	/* Question 9:
  	Find the diamter of the tree.
  	*/
  	public static int diameterOfTree(TreeNode root) {

		if (root == null)
			return 0;
		int rootDiam = heightOfNode(root.left) + heightOfNode(root.right) + 1;
		int rootLeftDiam = diameterOfTree(root.left);
		int rootRightDiam = diameterOfTree(root.right);

		return Math.max(rootDiam, Math.max(rootLeftDiam, rootRightDiam));
	}
	// Height of the given node
	public static int heightOfNode(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int a = heightOfNode(root.left);
		int b = heightOfNode(root.right);
		return Math.max(a, b) + 1;
	}

        /* Question 10:
        Print the all the sum from root to leaf node 
        */
	public static void sumRootToLeaf(TreeNode root, int sum) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.print(root.value + sum + " ");
		} else {
			sum += root.value;
			sumRootToLeaf(root.left, sum);
			sumRootToLeaf(root.right, sum);
		}

	}
       
       
       */
