
    /*
    Question 1: Knapsack with infinite number of items.
    Question 2: Knapsack without repetion of the items.
    
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
	
	
