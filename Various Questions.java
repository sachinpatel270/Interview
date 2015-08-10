	/*   L I S T   O F   Q U E S T I O N S  
	Question 1: Print the number of 13 appearing in the numbers till a given number n
	Question 2: Check whether given string is palendrome or not (not case sensitive, "Pe  aC EcA e p " is palendrome)
	Question 3: Shortest subsequence of the array that add up to the given number
	Question 4: Given two strings, check whether they are anagrams or not. 
	Question 5: Ingeneral write a program to output unbiased outcome from biased coin.
        Question 6: Convert the given string of number into a number. ex: in = "-123", out = -123
        
	
	*/




	/*Question 1:
	Print the number of 13 appearing in the numbers till a given number n
	*/
	public static int numberof13tillN(int n) {
		int count = 0;

		for (int i = 0; i < n; ++i) {
			count += numberof13(i);
		}
		return count;
	}

	public static int numberof13(int n) {

		String sn = Integer.toString(n);
		int count = 0;
		for (int i = 0; i < sn.length() - 1; ++i) {
			if (sn.charAt(i) == '1' && sn.charAt(i + 1) == '3') {
				++count;
				break;
			}
		}
		return count;
	}
	/* Question 2:
	Check whether given string is palendrome or not (not case sensitive)
	ex: input= "Pe  aC EcA e p " output= true
	*/
		public static boolean isPalendrome(String str) {

		char[] chstr = str.toCharArray();
		int l = 0;
		int r = chstr.length - 1;

		while (l < r) {

			if (chstr[l] == ' ')
				++l;
			else if (chstr[r] == ' ')
				--r;
			else if (Math.abs(chstr[l] - chstr[r]) != 32
					&& Math.abs(chstr[l] - chstr[r]) != 0)
				return false;
			else {
				++l;
				--r;
			}
		}
		return true;
	}
	
	/* Question 3: 
	Shortest subsequence of the array that add up to the given number(numbers are positive integers)
	*/
	public static int[] shortestSubSeq(int[] ar, int n) {

		int head = 0; // beginning of sliding window
		int end = 0; // end of the sliding window
		int sum = 0;
		int[] coordinate = new int[2];
		int currentMin = Integer.MAX_VALUE;
		int absMin = Integer.MAX_VALUE; // huge number

		while (end < ar.length) {
			
			if (sum < n) {
				sum += ar[end];
				++end;
			} else if (sum == n) {
				currentMin = end - head;
				if (absMin > currentMin) {
					absMin = currentMin;
					coordinate[0] = head;
					coordinate[1] = end;
				}
				sum -= ar[head];
				++head;
			} else {
				sum -= ar[head];
				++head;
			}
		}

		int[] output = new int[absMin];
		System.arraycopy(ar, coordinate[0], output, 0, absMin);
		return output;
	}
	
	/*Question 4:
	Given two strings, check whether the are anagrams or not.
	*/
	public static boolean isAnagram(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;

		int[] freq1 = new int[256];
		int[] freq2 = new int[256];

		for (int i = 0; i < str1.length(); ++i) {

			++freq1[str1.charAt(i)];
			++freq2[str2.charAt(i)];

		}
		return Arrays.equals(freq1, freq2);
	}
	
	/* Question 5: 
	 * Probability of getting 1 is 0.25, and getting 0 is 0.75. Write program to return 0 or 1 equally likely
	 * Ingeneral write a program to output unbiased outcome from biased coin
	 */
	public static int biasedCoinToUnbiased() {

		int[][] M = { { 1, 2 }, { 3, 4 } };

		int i = biasedCoin();
		int j = biasedCoin();
		if (M[i][j] == 2)
			return 0;
		if (M[i][j] == 3)
			return 1;
		else
			return biasedCoinToUnbiased();

	}

	// biased coin for testing: 1 with probability .25, and 0 with probability .75
	public static int biasedCoin() {

		int[][] M = { { 1, 2 }, { 3, 4 } };
		int i = (int) (2 * Math.random());
		int j = (int) (2 * Math.random());

		return (M[i][j] == 1) ? 1 : 0;
	}
	
	/*Question 6:
	Convert the given string consisting of number into a number.
	ex: input = "-1234", output = -1234.
	 */

	public static int stringToInteger(String str) {

		int output = 0;
		int sign = 1;
		int index = 0;
		int i = str.length() - 1;

		if (str.charAt(0) == '-') {
			sign = -1;
			index = 1;
		}
		while (i >= index) {

			output += (str.charAt(i) - 48) * Math.pow(10, str.length() - 1 - i);
			--i;
		}
		return sign * output;
	}
	
	
	
	
	
	
	
	
