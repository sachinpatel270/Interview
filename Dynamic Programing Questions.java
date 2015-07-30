    /* Question 1: 0-1 Knapsack (knapsackNoRep)
       Question 2: Knapsack with infinite item (knapsackWithRep)
       Question 3: Length of Longest common subsequence (lengthOfLCA)
       Question 4: Longest common subsequence (LCA)
    */
    
    
    
    /*Question 1: Knapsack problem without repetition
    w= weight array, v= value array, tw = total weight capacity of knapsack. Aim is to maximize the
    total value in Knapsack.
    */
	
	  // w= weight array, v = value array, tw = total capacity of Knapsack
	public static int knapsackNoRep(int[] w, int[] v, int tw) {

		int[][] M = new int[w.length + 1][tw + 1];

		for (int i = 1; i < w.length + 1; ++i) {
			for (int j = 1; j < tw + 1; ++j) { // j is the current capacity
				if (j >= w[i - 1])
					/*if current capaicty is greater then ith item weight,
					  then either I will take it or leave it depending on how they affect
					  total gain */
					
					M[i][j] = Math.max(v[i - 1] + M[i - 1][j - w[i - 1]], M[i - 1][j]);
				else
					M[i][j] = M[i - 1][j]; 
			}
		}
		return M[w.length][tw];
	}

        /*Question 3:
	 Length of the longest common subsequence of given two strings. 
	 ex:inputs= "peacefully", "ecology" output:4 (ecly);
	*/
	public static int lengtOfLCA(String s1, String s2) {
		int max = 0;
		String subSeq = "";
		int[][] M = new int[s1.length() + 1][s2.length() + 1];
		
		// finding the length of LCA
		for (int i = 1; i < s1.length() + 1; ++i) {
			for (int j = 1; j < s2.length() + 1; ++j) {
			
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
				M[i][j] = M[i - 1][j - 1] + 1;
				else
				M[i][j] = Math.max(M[i - 1][j],M[i][j - 1]);
				
			max = (max < M[i][j])?M[i][j]:max;
				
			}
		}
	
	//	System.out.print("Length of the LCA:" + max);
	return max;	
            
	}





