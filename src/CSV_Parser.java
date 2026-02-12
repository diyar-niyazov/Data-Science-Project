
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// Parses a CSV file and stores each line as an ArrayList of String arrays
public class CSV_Parser {

    private final File CSV_FILE;
    private final ArrayList<String[]> valuesArray = new ArrayList<>();

    public CSV_Parser(String fileName) {
        CSV_FILE = Paths.get("assets", fileName).toFile();
        parseCSV();
    }

    // Reads and splits the CSV file into an array
    public void parseCSV() {
        String line;
        try (Scanner scanner = new Scanner(CSV_FILE)) {

            // Skips header
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

    // Removes commas within quoted text to avoid splitting inside quotes
    public static String removeInnerCommas(String line) {
        boolean inQuotes = false;
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            }
            if (inQuotes && c == ',') {
                result.append("");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Returns the parsed CSV file as an ArrayList of String arrays
    public ArrayList<String[]> getValuesArray() {
        return valuesArray;
    }
}
