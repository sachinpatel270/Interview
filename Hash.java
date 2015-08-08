	/* 
	Question 1: Taxicab Numbers. (x, such that x = a^3 + b^3 = c^3 + d^3, for different a,b,c,d)
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
