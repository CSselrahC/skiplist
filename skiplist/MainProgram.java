package skiplist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainProgram {
	public static void main (String[] args) throws IOException {
		
		// storage for the initial length of the linked list
		int length;
		
		// temporary storage for user input
		int number;
		
		// storage for number of nodes to be skipped
		int nodesToSkip = 0;
		
		// storage for the values of the last node
		int lastValue = 0;
		
		// storage for the user input for the menu
		char choice;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// creates the objects for the linked list and skip list
		LinkedList linkedList = new LinkedList();
		SkipList skipList = new SkipList();
		
		// sets the initial length of the linked list
		System.out.print("How many nodes? ");
		length = Integer.parseInt(reader.readLine());
		
		// initializes the linked list
		for (int i = 0; i < length; i++) {
			System.out.print("\nEnter a number: ");
			number = Integer.parseInt(reader.readLine());
			Node node = new Node(number);
			linkedList.addNode(node);
		}
		
		// sorts the list in ascending order
		System.out.println("\nSorting the list...");
		linkedList.bubbleSort();
		linkedList.displayList();
		
		do {
			System.out.println("[MENU]");
			System.out.println("[1] Add Node");
			System.out.println("[2] Display List");
			System.out.println("[3] Create Skip List");
			System.out.println("[4] Display Skip List");
			System.out.println("[5] Exit");
			System.out.print("Select an Operation: ");
			choice = reader.readLine().charAt(0);
			
			switch (choice) {
				case '1': // adds a new node to the linked list
					do {
						// input for the new node's data
						System.out.print("\nEnter a number: ");
						number = Integer.parseInt(reader.readLine());
						
						// retrieves the last node's value;
						Node currentNode = linkedList.getHead();
						while (currentNode.getNext() != null) {
							currentNode = currentNode.getNext();
						}
						lastValue = currentNode.getData();
						
						// the new node's data must not be lower than the last node's data
						if (lastValue >= number) {
							System.out.println("Number must be higher than the last value.");
						}
					} while (lastValue >= number); // repeat the input if new node's data is lower than last node's data
					
					// adds the new node to the linked list
					Node node = new Node(number);
					linkedList.addNode(node);
					
					// checks if existing skip list needs an update
					if (skipList.getHead() != null) {
						
						// retrieves the last node of the skip list
						SkipNode currentSkipNode = skipList.getHead();
						while (currentSkipNode.getNext() != null) {
							currentSkipNode = currentSkipNode.getNext();
						}
						
						// checks if there's a need to create a new node for the skip list based on the calculated number of nodes to be skipped
						Node currentNode = currentSkipNode.getBottom();
						for (int i = 1; i <= nodesToSkip + 1; i++) {
							if (currentNode != null) {
								currentNode = currentNode.getNext();
							}
						}
						
						// if number of nodes to be skipped was met then create a new node for the skip list
						if (currentNode != null) {
							SkipNode skipNode = new SkipNode();
							skipNode.setData(currentNode.getData());
							skipNode.setBottom(currentNode);
							skipList.addNode(skipNode);
						}
					}
					break;
				case '2': // displays the data of the linked list
					linkedList.displayList();
					break;
				case '3': // creates a skip list
					if (skipList.getHead() != null) {
						System.out.println("Already created a skip list.");
					} else {
						// computes the number of nodes to be skipped
						nodesToSkip = (int) Math.sqrt(linkedList.getLength());
						
						// creates the first node of the skip list
						SkipNode skipNode = new SkipNode();
						skipNode.setData(linkedList.getHead().getData());
						skipNode.setBottom(linkedList.getHead());
						skipList.addNode(skipNode);
						
						// creates the remaining nodes of the skip list
						Node currentNode = linkedList.getHead();
						while (currentNode != null) {
							for (int i = 1; i <= nodesToSkip + 1; i++) {
								if (currentNode != null) {
									currentNode = currentNode.getNext();
								} else {
									break;
								}
							}
							
							if (currentNode != null) {
								skipNode = new SkipNode();
								skipNode.setData(currentNode.getData());
								skipNode.setBottom(currentNode);
								skipList.addNode(skipNode);
							}
						}
						System.out.println("\nSkip list created!");
					}
					break;
				case '4': // displays the data of the skip list
					skipList.displayList();
					break;
				case '5': // exits the program
					System.out.println("\nGood bye!");
					break;
				
				default:
					System.out.println("\nInvalid choice!");
			}
		} while (choice != '5'); // ends the program if the user selected 'Exit' from the menu
	}
}
