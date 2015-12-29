	/* QUESTIONS:
	Question 1: Return the intersection of two LinkedLists 
	Question 2: Find that if there is a loop in the given linkedlist.
	Question 3: Reverse the Singly Linked List
	Question 4: Reverse the Doubly Linked List
	*/
	
	
	
	/* Question 1:
	Return the intersection of two LinkedLists 
	*/
	public static Object intersectionsOfLLs(LinkedList L1, LinkedList L2) {

		if (L1.size() > L2.size()) {

			int L1size = L1.size();
			int L2size = L2.size();
			int diff = L1size - L2size;

			LinkedList temp1 = L1;
			LinkedList temp2 = L2;

			while (diff > 0) {
				temp1.poll();
				--diff;
			}
/*Methods for collections 

Poll gets the head of the list and removes it from the list
Peek gets the head/look at the top of stack But does not remove it
PUSH adds the element in front of the list
ADD adds the element at the specified position in the list*/

			while (!temp1.peek().equals(temp2.peek())) {
				temp1.poll();
				temp2.poll();
			}
			return (!temp1.equals(null))?temp1.peek():-1;;
		} else if (L1.size() <= L2.size())
			return intersectionsOfLLs(L2, L1);
		else
			return -1;

	}
        /* Question 3:
        Reverse the Singly Linked List
        */
       	public static void reverseSLL() {

		Node temp0 = null;
		Node temp1 = head;
		Node temp2 = head.next;

		while (temp2 != null) {
			// reverse the pointers
			Node temp = temp2.next;
			temp2.next = temp1;
			temp1.next = temp0;

			// shift the  position of pointers
			temp0 = temp1;
			temp1 = temp2;
			temp2 = temp;

		}

		head = temp1;

	}
