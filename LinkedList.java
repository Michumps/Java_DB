import java.util.List;

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

		while (travNode != null) {
			if (travNode.key.equals(key)) {
				return travNode.value;
			}

			travNode = travNode.next;
		}

		// Return empty string for nonexistent key
		return "";
	}

	public void printList() {
		Node travNode = head;

		if (travNode == null) {
			System.out.println("No List to print!");
			return;
		}

		while (travNode != null) {
			System.out.println("Key: " + travNode.key + " Value: " + travNode.value);

			travNode = travNode.next;
		}
	}

	public void setValue(String key, String value) {
		if (head == null) {
			addNode(key, value);
			return;
		}

		Node travNode = head;

		// traverses the list to check if key already exists, if so overwrites node
		while (travNode != null) {
			if (travNode.key.equals(key)) {
				travNode.value = value;
				return;
			}

			travNode = travNode.next;

		}

		// if not adds new node with key-value pair
		addNode(key, value);
	}

	public void initializeList(List<String> inputList) {

		for (String line : inputList) {
			// Skip empty lines
			if (line == null || line.trim().isEmpty()) {
				continue;
			}

			String[] tokens = line.split(";");

			// Ensure that we have enough tokens before accessing them
			if (tokens.length >= 3 && tokens[0].equals("SET")) {
				setValue(tokens[1], tokens[2]);
			}
		}

	}

	LinkedList() {
		this.head = null;
		this.tail = null;
	}
}
