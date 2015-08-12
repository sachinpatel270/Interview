    /* Question 1: 0-1 Knapsack (knapsackNoRep)
       Question 2: Knapsack with infinite item (knapsackWithRep)
       Question 3: Length of Longest common subsequence (lengthOfLCSubSeq)
       Question 4: Longest common substring (LCSubString)
       Question 5: Coin change (#of ways to form a given sum with the given set of coins)
       Question 6: Length of the Longest palindromic subsqeunce of a given string 
       Question 7: Length of longest increasing subsequence.
       Question 8: Check that whether you can fund a subset of the given nonnegative array such that,
       total sum of that subset is equal to the	given number.
       
    */
    
    
    
      /*Question 1: 
       Knapsack problem without repetition
       w= weight array, v= value array, tw = total weight capacity of knapsack. Aim is to maximize the
       total value in Knapsack.
       */
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
	 Coin change problem, you have an infinite supply of coins, you are given a target sum.
	 Print the number of ways that you can form a sum with these coins
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
	
       	/* Question 6: 
	 Find the length of longest palindromic subsequence.
	*/
	public static int LLpalindromicSSwithDP(String str) {

		int strLen = str.length();
		int[][] M = new int[strLen][strLen];

		/* Initalization of M. M[i][j] is defined as LLPSS(str.substring(i,j+1) */
		for (int i = 0; i < strLen; ++i) {
			M[i][i] = 1;
		}

		// Filling the upper triangular part of M from bottom-right to top-right
		for (int i = strLen - 2; i >= 0; --i) {
			for (int j = i + 1; j < strLen; ++j) {
				if (str.charAt(i) == str.charAt(j))
					M[i][j] = M[i + 1][j - 1] + 2;
				else
					M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);
			}
		}

		return M[0][strLen - 1];
	}

        /* Question 7:
        Find the length longest increasing subsequence
	*/
	public static int LLincreasingSubseq(int[] ar) {

		int[] memo = new int[ar.length];
		int[] trace = new int[ar.length];
		int bestStop = 0;

		for (int i = 0; i < ar.length; ++i) {
			memo[i] = 1;
			trace[i] = -1;
		}

		for (int i = 1; i < ar.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (ar[j] < ar[i]) {
					memo[i] = Math.max(memo[j] + 1, memo[i]);
					if (memo[i] == memo[j] + 1)
						trace[i] = j;
				}
			}
		}
		for (int i = 0; i < ar.length; ++i)
			bestStop = (trace[bestStop] < trace[i]) ? i : bestStop;

		int i = bestStop;
		while (i >= 0) {
			System.out.print(ar[i] + " ");
			i = trace[i];
		}
		return memo[bestStop];
	}
	/* Question 8: 
	Check that whether you can fund a subset of the given
	nonnegative array such that, total sum of that subset is equal to the
	given number
	*/
	public static boolean isThereSubsetToSum(int[] ar, int n) {
		Arrays.sort(ar);
		int arLen = ar.length;
		boolean[][] B = new boolean[arLen][n + 1];

		for (int i = 0; i < arLen; ++i) {

			if (i < n + 1)
				B[0][i] = (ar[0] == i) ? true : false;
			B[i][0] = true;
		}
		for (int i = 1; i < arLen; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				if (ar[i] > j)
					B[i][j] = B[i - 1][j];
				else
					B[i][j] = B[i - 1][j - ar[i]] || B[i - 1][j];
			}
		}

		return B[arLen - 1][n];
	}



