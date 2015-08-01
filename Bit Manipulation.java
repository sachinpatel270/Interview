
    /* Question 1:Given an array of numbers, all numbers are doubled except one, find that number
      Question 2:Given an array of numbers, print the numbers that are repeated 3 times.
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
