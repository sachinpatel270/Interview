    /* Qustion 1: 0-1 Knapsack */
    
    
    
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
