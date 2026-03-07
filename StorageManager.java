import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class StorageManager {

	private static final String dataFile = "data.db";
	private Path dataPath = Paths.get(dataFile);

	public void append(String log) {
		try (BufferedWriter myWriter = Files.newBufferedWriter(
			dataPath,
			StandardOpenOption.CREATE, // checks if file is already created, if not, creates it
			StandardOpenOption.APPEND))	{
				myWriter.write(log);
				System.out.println("Successfully wrote log to data.db");
		} catch (IOException e) {
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
	}

	public List<String> readFromFile() {

		try {
			List<String> myList = Files.readAllLines(dataPath);
			return myList;
		} catch (IOException e) {
			System.out.println("An error has occured: ");
			e.printStackTrace();
			// Empty immutable list if there is an IOException
			List<String> errorList = List.of();
			return errorList;
		}
		
	}

	StorageManager() {
		try {
			if (!Files.exists(dataPath)) {
				Files.createFile(dataPath);
			}
		} catch (IOException e) {
			System.out.println("Error occured with file");
			e.printStackTrace();
		}
	}

}
