	/* 
	Question 1: Taxicab Numbers. (x, such that x = a^3 + b^3 = c^3 + d^3, for different a,b,c,d)
	Question 2: Ingeneral write a program to output unbiased outcome from biased coin
	
	
	*/
	
	
	
	
	/* Question 1:
	Print the all numbers which can be written 2 different ways as a sum of 2 cubes
	i.e Print all x, such that x = a^3 + b^3 = c^3 + d^3, for different a,b,c,d
	*/
	public static void taxicabNumbers() {

		HashSet<Integer> H = new HashSet<Integer>();

		int i = 1, j = 0;
		int n = (int) Math.cbrt(Integer.MAX_VALUE);;
		while (i < n) {
			j = i + 1;
			while (j < n) {
				int sum = (int) (Math.pow(i, 3) + Math.pow(j, 3));
				if (H.contains(sum))
					System.out.print(sum + " ");
				else {
					H.add((int) sum);
				}
				++j;
			}
			++i;
		}
	}
	
	/* Question 2:
	 Probability of getting 1 is 0.25, and getting 0 is 0.75. Write program to return 0 or 1 equally likely
	 Ingeneral write a program to output unbiased outcome from a biased coin
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
