
    /*Question 1: Given an array of numbers, all numbers are doubled except one, find that number.
      Question 2: In general write a program to output unbiased outcome from biased coin.
      Question 3: Given an array of numbers, print the numbers that are repeated 3 times.
    */


    /* Question 1:
    Given an array of numbers, all numbers are doubled except one, find that number
    input: [1,4,2,3,5,4,3,1], output:5
    */

	public static int findSingleton(int[] ar) {

		int mask = 0;
		for (int i = 0; i < ar.length; ++i) {
			mask ^= ar[i];
		}
		return mask;
	}

	/* Question 2: 
	 Probability of getting 1 is 0.25, and getting 0 is 0.75. Write program to return 0 or 1 equally likely
	 In general write a program to output unbiased outcome from biased coin.
	 */
	public static int biasedCointoUnbiased1() {

		int i = biasedCoin();
		int j = biasedCoin();
		int k = i ^ j;

		return (k == 1) ? i : biasedCointoUnbiased1();
	}

	// biased coin for testing: 1 with probability .25, and 0 with probability .75
	public static int biasedCoin() {

		int[][] M = { { 1, 2 }, { 3, 4 } };
		int i = (int) (2 * Math.random());
		int j = (int) (2 * Math.random());

		return (M[i][j] == 1) ? 1 : 0;
	}
