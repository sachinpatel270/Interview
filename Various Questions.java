	/*   L I S T   O F   Q U E S T I O N S  
	Question 1: Print the number of 13 appearing in the numbers till a given number n
	Question 2: 
	
	
	
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
