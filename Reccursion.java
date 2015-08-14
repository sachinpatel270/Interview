
    /*
    Question 1: Knapsack with infinite number of items.
    Question 2: Knapsack without repetion of the items.
    Question 3: Least common subsequence if a given two sequence
    Question 4: Print all permutaion of a given string
    Question 5: Print the mimimum number of coin adding up to the given sum (coins array could be any integer!)
    Question 6: Return the list of subsets of the given string. ex: abc->[abc, ab, ac, bc, a, b, c, ]
    Question 7: Find the lengt of longest palindromic subsequence
    Question 8: For given number n, find the smallest number whose digits consists of only 0 and 7 and divisible by n.
    */





      /*Question 1:
      Knapsack Problem with repetition allowed, i.e there is an infinite number of items
      w= weight array, v= value array, tw =  weight capacity of knapsack. Aim is to maximize the
      total value in Knapsack.
      
      See a better solution in Dynamic Programming question section
      */
	
	public static int KnapsackWithRep(int[] w, int[] v, int tw) {
		int[] knapArray = new int[w.length];
		
		if (tw < minArray(w))
			return 0;
		else {
			for (int i = 0; i < w.length; ++i) {
				if (tw >= w[i])
					knapArray[i] = KnapsackWithRep(w, v, tw - w[i]) + v[i];
			}
		}
		return maxArray(knapArray);
	}
	
	public static int minArray(int[] ar) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < ar.length; ++i) {
			if (ar[i] < min)
			min = ar[i];
		}
		return min;
	}
	
	public static int maxArray(int[] ar) {
		int max = 0;

		for (int i = 0; i < ar.length; ++i) {
			if (max < ar[i])
			max = ar[i];
		}
		return max;
	}
	
      /*Question 2:
      Knapsack Problem with repetition, i.e there is only one item for each item.
      w= weight array, v= value array, tw =  weight capacity of knapsack. Aim is to maximize the
      total value in Knapsack.
      */
     
      /*Question 3:
      Least Common subsequence of a given two sequence. ex: Inputs: s1 = "peacefully", s2 = "ecology". Output= "ecly"
      */
     
     
     
     	public static String LCS(String s1, String s2) {
		int s1L = s1.length();
		int s2L = s2.length();
		if (s1.length() == 0 || s2.length() == 0)
			return "";

		if (s1.charAt(0) == s2.charAt(0))
			return s2.charAt(0) + LCS(s1.substring(1), s2.substring(1));
		else {
			String x = LCS(s1.substring(1), s2);
			String y = LCS(s1, s2.substring(1));
			return (x.length() > y.length()) ? x : y;

		}

	}

	/*Question 4;
	Print the all permutation of the given string. input = abc , output = abc acb bac bca cab cba
	*/
	
	public static void permutationPrinter(String str) {

		permutationPrinter(str, "");
	}

	public static void permutationPrinter(String str, String perm) {
		if (str.equals(""))
			System.out.print(perm + " ");
		else {
			for (int i = 0; i < str.length(); ++i) {
                //removing ith character from str and add it into perm string
				String strNew = str.substring(0, i) + str.substring(i + 1);
				String permNew = perm + str.charAt(i);
				permutationPrinter(strNew, permNew);

			}
		}

	}
	
	/*Question 5;
	Print the mimimum number of coin adding up to the given sum (coins could be any integer)
	If the combination is possible, then code will give desired result, otherwise it gives Interger.MAX
	ex1 input: ([3,5,9], 7) output:Integer.MAX. ex2: input([2,3,5,7], 16) output:3 since (7+7+2);
	*/
	public static int minCoinChange(int[] coins, int sum) {
		int result = Integer.MAX_VALUE;
		if (sum < 0)
			return Integer.MAX_VALUE - 1;
		if (sum == 0)
			return 0;

		for (int i = 0; i < coins.length; ++i) {
			result = Math.min(result, minCoinChange(coins, sum - coins[i]));
		}
		return result + 1;
	}
	
	/* Question 6:
	Return the list of subsets of the given string. ex: abc->[abc, ab, ac, bc, a, b, c, ]
	*/
	public static ArrayList<String> subsetPrinter(String str) {
		ArrayList<String> subset = new ArrayList<String>();
		String basket = "";
		return subsetPrinter(str, basket, subset);
	}

	public static ArrayList<String> subsetPrinter(String str, String basket,
			ArrayList<String> subset) {

		if (str.equals("")) {
			subset.add(basket);
		} else {
			String newBasket = basket + str.charAt(0);
			String newStr = str.substring(1);
			// 0th character is included or not included
			subsetPrinter(newStr, newBasket, subset);
			subsetPrinter(newStr, basket, subset);
		}

		return subset;

	}
	
	/* Question 7:
        Length of the longest palindromic subsequence of the give string (not necessarily continuous subsequence)
	*/
	public static int LLongestPalindromicS(String str) {

		if (str.length() == 0)
			return 0;
		else if (str.length() == 1) {
			return 1;
		} else if (str.length() > 1
				&& str.charAt(0) == str.charAt(str.length() - 1))
			return LLongestPalindromicS(str.substring(1, str.length() - 1)) + 2;
		else {
			int a = LLongestPalindromicS(str.substring(0, str.length() - 1));
			int b = LLongestPalindromicS(str.substring(1, str.length()));
			return Math.max(a, b);
		}

	}
	
	/* Question 8:
	For given number n, find the smallest number whose digits consists of only 0 and 7 and divisible by n.
        */
       	public static int comb07(int n) {
		int a = comb07(7, n);
		return (a == Integer.MAX_VALUE) ? -1 : a;
	}

	public static int comb07(int number, int n) {

		if (number > Integer.MAX_VALUE / 10) // to avoid overflow
			return Integer.MAX_VALUE;

		if (number % n == 0)
			return number;

		int a = comb07(number * 10, n);
		int b = comb07(number * 10 + 7, n);

		return Math.min(b, a);

	}
	
