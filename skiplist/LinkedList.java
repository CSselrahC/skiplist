package skiplist;

public class LinkedList {
	
	// storage for the address of the first node
	private Node head;
	
	// set and get methods for the first node
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	// method for adding a new node
	public void addNode(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}
	
	// method for displaying the contents of the linked list
	public void displayList() {
		if (head != null) {
			System.out.print("\nThe values are: ");
			Node currentNode = head;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		} else {
			System.out.println("\nThe list is empty!");
		}
	}
	
	// method for getting the length of the linked list
	public int getLength() {
		int counter = 0;
		Node currentNode = head;
		while (currentNode != null) {
			counter++;
			currentNode = currentNode.getNext();
		}
		
		return counter;
	}
	
	// method for sorting the linked list
	public void bubbleSort() {
		boolean noChanges = true;
		int temp;
		
		Node currentNode = head;
		while (currentNode.getNext() != null) {
			if (currentNode.getData() > currentNode.getNext().getData()) {
				temp = currentNode.getData();
				currentNode.setData(currentNode.getNext().getData());
				currentNode.getNext().setData(temp);
				noChanges = false;
			}
			currentNode  = currentNode.getNext();
		}
		
		if (noChanges == false) {
			bubbleSort();
		}
	}
}
