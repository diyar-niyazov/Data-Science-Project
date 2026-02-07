
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// Parses the CSV file and stores each value in a String array in an ArrayList
public class CSV_Parser {

    private final String fileName;
    private final File CSV_FILE;
    private final ArrayList<String[]> valuesArray = new ArrayList<>();

    public CSV_Parser(String fileName) {
        this.fileName = fileName;
        CSV_FILE = Paths.get("assets", this.fileName).toFile();
        parseCSV();
    }

    public void parseCSV() {
        String line;
        try (Scanner scanner = new Scanner(CSV_FILE)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.contains("\"")) {
                    line = removeInnerCommas(line);
                }
                valuesArray.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        }
    }

    public static String removeInnerCommas(String line) {
        boolean inQuotes = false;
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            }
            if (inQuotes && c == ',') {
                result.append(" ");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public ArrayList<String[]> getValueArray() {
        return valuesArray;
    }
}
