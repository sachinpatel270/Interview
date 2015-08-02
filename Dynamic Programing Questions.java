    /* Question 1: 0-1 Knapsack (knapsackNoRep)
       Question 2: Knapsack with infinite item (knapsackWithRep)
       Question 3: Length of Longest common subsequence (lengthOfLCSubSeq)
       Question 4: Longest common substring (LCSubString)
       Question 5: Coin change (#of ways to form a given sum with the given set of coins)
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
	public static int lengthOfLCSubSeq(String s1, String s2) {
		int max = 0;
		String subSeq = "";
		int[][] M = new int[s1.length() + 1][s2.length() + 1];
		
	
		for (int i = 1; i < s1.length() + 1; ++i) {
			for (int j = 1; j < s2.length() + 1; ++j) {
			
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
				M[i][j] = M[i - 1][j - 1] + 1;
				else
				M[i][j] = Math.max(M[i - 1][j],M[i][j - 1]);
				
			max = (max < M[i][j])?M[i][j]:max;
				
			}
		}
	
	//	System.out.print("Length of the LCSubSeq:" + max);
	return max;	
            
	}
	
	
	
        /* Question 4:
        find the longest common substring if a given 2 strings.
        ex: inputs: onemorecupof, coffeebeforeigo, output: ore (NOT oreo, it must be continuous)
        */

	public static String LCSubString(String s1, String s2) {
		int max = 0; // for the length of output
		int k = 0, l = 0; // for the coordinate of max,
		String output = "";
		int[][] M = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < s1.length() + 1; ++i) {
			for (int j = 1; j < s2.length() + 1; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					M[i][j] = M[i - 1][j - 1] + 1;

				if (max < M[i][j]) {
					max = M[i][j];// keeping Max
					k = i;// keeping the coordinate (k,l) when max is updated
					l = j;
				}
			}
		}
		// forming the longest common substring
		while (M[k][l] != 0) {
			output = s1.charAt(k - 1) + output;
			--k;
			--l;
		}
		System.out.println("The length of LCSubstrings is: " + max
				+ " and the substring is : " + output);
		return output;
	}
	
	/*Question 4:
	 Coin change problem, you have an infinite supply of coins, you are given a target sum, print the number of ways that you can form a sum with these coins
	 ex input ([1,2,5], 4) output=3, since (1,1,1,1),(1,1,2),(2,2)
	 */
	public static int howManyWaysToChange(int[] coins, int sum) {
		
		int r = coins.length;
		int c = sum+1;
		int[][] M = new int[r][c];
		
		//Initializing the first column and first row of the matrix M
		for (int i = 0; i < r; ++i) {
			for(int j = 0; j < c; ++j){
				if((j%coins[0] == 0)&&(i == 0 || j == 0))
					M[i][j] = 1;
			}
		}
		for (int i = 1; i < r; ++i) {
			for(int j = 1; j < c; ++j){
				if(coins[i]>j)
					M[i][j] = M[i-1][j];
				else
					M[i][j] = M[i-1][j] + M[i][j-coins[i]];
			}
		}
		return M[r-1][c-1];
	}



