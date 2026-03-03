public class LinkedList {

	private Node head;
	private Node tail;

	// private nested Node class
	private static class Node {
		private String key;
		private String value;
		private Node next;

		public Node (String key, String value) {this.key = key; this.value = value; this.next = null;}
	}

	// adds a key-value node to the list
	public void addNode(String key, String value) {
		Node newNode = new Node(key, value);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;	
		}
	}

	// gets value for a specified key, if it exists
	public String getValue(String key) {
		Node travNode = head;

		while (travNode.next != null) {
			if (travNode.key == key) {
				return travNode.value;
			}

			travNode = travNode.next;
		}

		return "No value for that key found";
	}

	public void printList() {
		Node travNode = head;

		while (travNode != null) {
			System.out.println("Key: " + travNode.key + " Value: " + travNode.value);

			travNode = travNode.next;
		}
	}

	public void setValue(String key, String value) {
		if (head == null) {
			System.out.println("No list created yet!");
			return;
		}

		Node travNode = head;

		// traverses the list to check if key already exists, if so overwrites node
		while (travNode != null) {
			if (travNode.key == key) {
				travNode.value = value;
				return;
			}
		}

		// if not adds new node with key-value pair
		addNode(key, value);
	}

	LinkedList() {
		this.head = null;
		this.tail = null;
	}
}
