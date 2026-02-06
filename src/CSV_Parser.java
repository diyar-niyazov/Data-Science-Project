import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV_Parser {

    private final String fileName;
    private final File CSV_FILE;
    private ArrayList<String[]> valuesArray;

    public CSV_Parser(String fileName) {
        this.fileName = fileName;
        CSV_FILE = Paths.get("assets", this.fileName).toFile();
        parseCSV();
    }

    public void parseCSV() {
        try (Scanner scanner = new Scanner(CSV_FILE)) {
            while (scanner.hasNextLine()) {
                valuesArray.add(scanner.nextLine().split(","));
            }
        } catch (IOException e) {
            System.err.println("File doesn't exist.");
        }
    }

    public ArrayList<String[]> getValueArray() {
        return valuesArray;
    }
}
