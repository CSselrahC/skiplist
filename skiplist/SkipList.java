package skiplist;

public class SkipList {
	
	// storage for the first node of the skip list
	private SkipNode head;
	
	// set and get methods for the first node
	public SkipNode getHead() {
		return head;
	}
	
	public void setHead(SkipNode head) {
		this.head = head;
	}
	
	// method for adding a new node
	public void addNode(SkipNode node) {
		if (head == null) {
			head = node;
		} else {
			SkipNode currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}
	
	// method for displaying
	public void displayList() {
		if (head != null) {
			System.out.print("\nThe values are: ");
			SkipNode currentNode = head;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		} else {
			System.out.println("\nThe list is empty.");
		}
	}
}
