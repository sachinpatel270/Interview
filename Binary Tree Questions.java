public class TreeNode {

	  int value;
	  TreeNode left;
	  TreeNode right;
	  
	  	TreeNode(int val){
	  		
	  		this.value = val;
	  		this.left = null;
	  		this.right = null;
	  		
	  	}
	
	/* Question: Convert a given array to a binary tree with minimum height */
	
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
	
	}
