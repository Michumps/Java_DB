import java.util.Scanner;

public class Main {
	public static void main(String args[]){

		Scanner scanner = new Scanner(System.in);
		LinkedList linkedList = new LinkedList();
		StorageManager storageManager = new StorageManager();

		linkedList.initializeList(storageManager.readFromFile());

		MAIN_LOOP:
		while(true) {

			String command = scanner.nextLine();
			command = command.trim(); // Remove leading/trailing whitespace

			String[] tokens = command.split(" ");

			if (tokens[0] == null || tokens[0].isEmpty()) {
				System.out.println("Error reading from STDIN please try again");
				continue;
			}

			switch(tokens[0]) {
				case "SET":
					linkedList.setValue(tokens[1], tokens[2]);
					storageManager.append("SET;" + tokens[1] + ';' + tokens[2]);
					break;

				case "GET":
					System.out.println(linkedList.getValue(tokens[1]));
					System.out.flush();
					break;
				case "EXIT":
					break MAIN_LOOP; // labeled break to break while loop
				
				default:
					System.out.println("Error reading command, Syntax: SET <key> <value>, GET <key>, EXIT");
			}

		}

		scanner.close();

	}
}