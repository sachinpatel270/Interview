	public static int maxsubseq(int[] ar) {

		int curMax = 0;
		int absMax = 0;

		for (int i = 0; i < ar.length; ++i) {
		
			curMax += ar[i];
			curMax = (curMax < 0) ? 0 : curMax;
			absMax = (curMax > absMax) ? curMax : absMax;
		}
		return absMax;
	}
