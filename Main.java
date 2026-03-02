import java.util.Scanner;

public class Main {
	public static void main(String args[]){

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your name: ");

		String myName = scanner.nextLine();

		System.out.println(myName);

		scanner.close();

	}
}