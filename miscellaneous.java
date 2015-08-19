
	/*  QUESTION LIST

	Question 1: Celebrity problem : There are n number of people in party and only one celebrity.
	Question 2:

	*/






	/* Question 1:
	Celebrity problem : There are n number of people in party and only one celebrity.
	If celebrity is the person, who knows no one but everyone knows him, find who is the celebrity? 
	Given: a function is provided which tells whether ‘a’ knows ‘b’ or not? doesAknowB(A,B).
	Hint: Push all the elements into stack. Remove top two elements(say A and B), and keep A if B knows A and A does not know B.
	Remove both A,B is both know each other.
	*/
	
	
	
	public static String findCelebrity(String[] guestlist) {
		int len = guestlist.length;

		if (len == 0) {
			return "Is there anybody out there ? ";
		}
		if (len == 1)
			return "There you go! Celebrity is " + guestlist[0];
		Stack<String> S = new Stack<String>();
		for (int i = 0; i < len; ++i) {
			S.push(guestlist[i]);
		}
		while (S.size() != 1) {
			String temp = S.pop();

			if (doesAknowB(temp, S.peek()))
				continue;
			else {
				S.pop();
				S.push(temp);
			}
		}
		return S.pop();
	}
