	/*   L I S T   O F   Q U E S T I O N S  
	Question 1: Print the number of 13 appearing in the numbers till a given number n
	Question 2: Check whether given string is palendrome or not (not case sensitive, "Pe  aC EcA e p " is palendrome)
	Question 3: Shortest subsequence of the array that add up to the given number
	Question 4: Given two strings, check whether they are anagrams or not. 
	Question 5: Ingeneral write a program to output unbiased outcome from biased coin.
        Question 6: Convert the given string of number into a number. ex: in = "-123", out = -123
        Question 7: Implemenation of  isSubstring method.
        Question 8: Find the sum of any rectangle in a given  matrix.
                    You will be given the coordinates of two opposite corners(Left-Top and right-bottom)
        Question 9: Return subarray of given array with maximum sum.   
        Question 10: For given number n, find the smallest number whose digits consists of only 0 and 7 and divisible by n.
        Question 11: Random shuffle of arrays.
        Question 12: Number of path ina Maze(from top left to right bottom, moves are only to the right and to the down)
	Question 13: Maximum of a sliding windows of size k over the array of length n>k.
	Question 14: Check that whether pharanthesis are properly opened and closed.
	Question 15: Find the nonrepeated element in a sorted array in log(n) time.
	Question 16: Trapping rain water between buildings
	Question 17: Alternating number: Given positif and negative numbers in array, rearrange the array with alternating sign.
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
	
	/* Question 7
	Implementation of isSubstring method.
	*/
	public static boolean isSubstring(String main, String str) {
		int strLen = str.length();
		int mainLen = main.length();
		int start = 0;
		int runner = 0;
		int match = 0;
		while (runner < mainLen) {

			if (main.charAt(runner) == str.charAt(start)) {
				++start;
				++runner;
				++match;
				if (match == strLen) {
					return true;
				}
			} else {
				runner = runner - match +1;//back to comparison position +1
				match = 0;
				start = 0;// restart
				++runner;
			}
		}
		return false;
	}
	/*Question 8: 
	Find the sum of any rectangle in a given  matrix. You will be given the coordinates of two opposite corners(Left-Top and right-bottom) 	
	*/
	public static int rectangleSum(int[][] M, int[] LT, int[] RB) {
		
		int[][] Mnew = matrixToSumMatrix(M);
		int output = 0;
		
		if (LT[0] > 0 && LT[1] > 0) {
			output = Mnew[RB[0]][RB[1]] + Mnew[LT[0] - 1][LT[1] - 1]
					- Mnew[RB[0]][LT[1] - 1] - Mnew[LT[0] - 1][RB[1]];
		} else if (LT[0] == 0 && LT[1] != 0) {
			output = Mnew[RB[0]][RB[1]] - Mnew[RB[0]][LT[1] - 1];
		} else if (LT[1] == 0 && LT[0] != 0) {
			output = Mnew[RB[0]][RB[1]] - Mnew[LT[0] - 1][RB[1]];
		} else {
			output = Mnew[RB[0]][RB[1]];
		}
		return output;
	}
	/Finding the sum matrix in place. New M[i][j] is the some of the rectangle determined by (0,0),(0,j),(i,0),(i,j). 
	public static int[][] matrixToSumMatrix(int[][] M) {
                //First column and first row are handled seperately
		for (int i = 0; i < M.length-1; ++i) {
			M[i+1][0] += M[i][0];
			M[0][i+1] += M[0][i];
		// Rest is handled iteratively	
		for (int i = 1; i < M.length; ++i) {
			for (int j = 1; j < M.length; ++j) {
				M[i][j] = M[i][j] + M[i][j - 1] + M[i - 1][j] - M[i - 1][j - 1];
			}
		}

		return M;
	}
	
	/*Question 9: 
	Return subarray of the gicen array with maximum sum.
	ex1 [-1,-3,4,-2,2,-1,3]--> [4,-2,2,-1,3]. ex2 [-2,-1,-5,-3] ---> [-1].
	*/
	public static int[] subArrayWithMaxSum(int[] ar) {

		int len = ar.length;
		int cursum = ar[0];
		int abssum = ar[0];
		int beginnew = 0;
		int beginprev = 0;
		int end = 0;
		for (int i = 0; i < len; ++i) {

			if (ar[i] > cursum + ar[i]) {
				cursum = ar[i];
				beginprev = i;
			} else {
				cursum += ar[i];
			}
			if (abssum < cursum) {
				abssum = cursum;
				end = i;
				beginnew = beginprev;
			}

		}
		int[] output = new int[end - beginnew + 1];
		System.arraycopy(ar, beginnew, output, 0, end - beginnew + 1);
		return output;
	}
	
	/* Question 10:
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
        
	/* Question 11: 
	Random shuffle of arrays
	*/
	
		public static void shuffle(int[] ar) {

		int len = ar.length;

		for (int i = 0; i < len - 1; ++i) {
			int j = randomIndexGen(i + 1, len - 1);
			swap(ar, i, j);
		}
	}

	public static void swap(int[] ar, int n, int m) {

		ar[n] = ar[n] ^ ar[m];
		ar[m] = ar[m] ^ ar[n];
		ar[n] = ar[n] ^ ar[m];
	}

	public static int randomIndexGen(int begin, int end) {

		int rnumber = (int) ((end - begin + 1) * Math.random());

		return rnumber + begin;
	}
	
	/*Question 12
	 How many possible path are there for the robot if it moves only down and right on the N by N maze.
	 I.e How many different way robot starts at (0,0) and stops at (N-1,N-1).
	*/
     public static int NumberOfPossiblePath(int N){
    	 
    	 return numberOfPossiblePath(N, 0, 0);
     }
     
    public static int numberOfPossiblePath(int N, int m, int n) {
		
		if (m > N - 1 || n > N - 1)
			return 0; //stop reccursion out of bound :)
		if (m == N - 1 && n == N - 1)
			return 1; // hit the best dead-end
		
			int a = numberOfPossiblePath(N, m + 1, n);
			int	b = numberOfPossiblePath(N, m, n + 1);
		
		return a + b ; // sum 
	}
	
        /* Question 13: 
        Print the maximum of the sliding windows at each instance for a given array and the length of the windows
        */
        
        //Brute force O(nk):
        public static void maxSlidingWindow1(int[] ar, int k) {
		int n = ar.length;
		int max = 0;
		for (int i = 0; i < n - k + 1; ++i) {
			for (int j = 0; j < k; ++j) {
				if (max < ar[i + j])
					max = ar[i + j];

			}
			System.out.print(max);
			max = 0;
		}

	}
	
	/* Question 14:
	Check whether pharanthesis are properly opened and closed. Input is a string consisting of only the characters
	'(',')','{','}','[' anf ']'.
	*/
	public static boolean isValidMedium(String str) {

		char[] charpar = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < str.length()) {
			char c = charpar[i];
			if (stack.isEmpty()) {
				stack.push(c);

			} else if (stack.peek() == '(' && c == ')') {
				stack.pop();

			} else if (stack.peek() == '{' && c == '}') {
				stack.pop();

			} else if (stack.peek() == '[' && c == ']') {
				stack.pop();

			} else {
				stack.push(c);
			}
			++i;

		}

		return (stack.isEmpty());
	}
	/* Question 15:
	 Every element of the given sorted array is repeated but one, find that one in log(n) time.
	 */
	public static int findOddOneInSortedArray(int[] ar) {
		int l = ar.length;

		if (l == 1)
			return ar[0];
		if (l % 2 == 0 || l < 1)
			return -1;

		return findOddOneInSortedArray(ar, 0, l - 1);
	}

	public static int findOddOneInSortedArray(int[] ar, int beg, int end) {

		if (beg > end)
			return -1;
		int mid = (end + beg) / 2;

		if (beg == end)
			return ar[mid];
		if (mid % 2 == 0) {
			if (ar[mid] == ar[mid + 1])
				return findOddOneInSortedArray(ar, mid + 2, end);
			else
				return findOddOneInSortedArray(ar, beg, mid);
		} else {
			if (ar[mid] == ar[mid - 1])
				return findOddOneInSortedArray(ar, mid - 2, end);
			else
				return findOddOneInSortedArray(ar, beg, mid - 1);
		}

	}
	
	/* Question 16:
	 * Trapping rain water. Given n non-negative integers representing an
	 * elevation map where the width of each bar is 1, compute how much water it
	 * is able to trap after raining.
	 */

	public static int trappingWater(int[] ar) {

		int len = ar.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		int water = 0;

		// max from the left side,
		int max = 0;
		for (int i = 0; i < len; ++i) {
			if (max < ar[i])
				max = ar[i];
			leftMax[i] = max;

		}
        // max from right side
		max = 0;
		for (int i = len - 1; i >= 0; --i) {
			if (max < ar[i])
				max = ar[i];
			rightMax[i] = max;

		}

		for (int i = 0; i < len; ++i) {
			water += Math.min(leftMax[i], rightMax[i]) - ar[i];
		}
		return water;
	}
        /* Question 17: 
        Alternating number: Given positif and negative numbers in array, rearrange the array with alternating sign.
	*/
	
	public static int[] alternateArray(int[] ar) {

		Queue<Integer> pos = new LinkedList<Integer>();
		Queue<Integer> neg = new LinkedList<Integer>();
		for (int i = 1; i < ar.length; ++i) {

			if (ar[i] < 0)
				neg.add(ar[i]);
			else
				pos.add(ar[i]);

		}

		int i = 1;
		while (i < ar.length) {
			if (ar[0] < 0) {
				if (!pos.isEmpty())
					ar[i++] = pos.poll();
				if (!neg.isEmpty())
					ar[i++] = neg.poll();
			} else {
				if (!neg.isEmpty())
					ar[i++] = neg.poll();

				if (!pos.isEmpty())
					ar[i++] = pos.poll();
			}

		}

		return ar;
	}



