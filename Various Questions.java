	/*   L I S T   O F   Q U E S T I O N S  
	Question 1: Print the number of 13 appearing in the numbers till a given number n
	Question 2: Check whether given string is palendrome or not (not case sensitive, "Pe  aC EcA e p " is palendrome)
	
	
	
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
