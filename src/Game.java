
import java.util.Arrays;

public class Game {

    private final String[] values;
    private final String name, platform, genre, publisher;
    private final Double rank, year, naSales, euSales, jpSales, otherSales, globalSales;

    // Constructs a Game object from a CSV row represented as String[]
    // Parses numeric values and stores categorical values
    public Game(String[] values) {
        this.values = values;

        rank = parseDoubleField(CSV_Category.RANK);
        year = parseDoubleField(CSV_Category.YEAR);
        naSales = parseDoubleField(CSV_Category.NA_SALES);
        euSales = parseDoubleField(CSV_Category.EU_SALES);
        jpSales = parseDoubleField(CSV_Category.JP_SALES);
        otherSales = parseDoubleField(CSV_Category.OTHER_SALES);
        globalSales = parseDoubleField(CSV_Category.GLOBAL_SALES);

        name = values[CSV_Category.NAME.index()];
        platform = values[CSV_Category.PLATFORM.index()];
        genre = values[CSV_Category.GENRE.index()];
        publisher = values[CSV_Category.PUBLISHER.index()];
    }

    // Safely parses a double from the CSV row based on the CSV_Category enum
    // Treats "N/A" as 0.0
    public Double parseDoubleField(CSV_Category value) {
        try {
            String valueString = values[value.index()];
            if (valueString.equals("N/A")) {
                return 0.0;
            }
            return Double.valueOf(values[value.index()]);
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(values));
            return 0.0;
        }
    }

    // Returns the double value corresponding to the given CSV_Category enum
    // Returns 0 for any null value
    // Throws exception if the value is non-numeric
    public double getNumericField(CSV_Category value) {
        return switch (value) {
            case RANK ->
                rank == null ? 0 : rank;
            case YEAR ->
                year == null ? 0 : year;
            case NA_SALES ->
                naSales == null ? 0 : naSales;
            case EU_SALES ->
                euSales == null ? 0 : euSales;
            case JP_SALES ->
                jpSales == null ? 0 : jpSales;
            case OTHER_SALES ->
                otherSales == null ? 0 : otherSales;
            case GLOBAL_SALES ->
                globalSales == null ? 0 : globalSales;
            default ->
                throw new IllegalArgumentException(
                        "Non-numeric category: " + value);
        };
    }

    // Returns the string value corresponding to the given Value enum
    // Throws exception if the Value is non-text
    public String getCategoricalField(CSV_Category value) {
        return switch (value) {
            case NAME ->
                name;
            case PLATFORM ->
                platform;
            case GENRE ->
                genre;
            case PUBLISHER ->
                publisher;
            default ->
                throw new IllegalArgumentException(
                        "Non-text category: " + value);
        };
    }

    // Prints all fields of the Game object in a readable format
    public void printGame() {
        System.out.println("Rank: " + rank
                + "\nName: " + name
                + "\nPlatform: " + platform
                + "\nYear: " + year
                + "\nGenre: " + genre
                + "\nPublisher: " + publisher
                + "\nNA Sales: " + naSales
                + "\nEU Sales: " + euSales
                + "\nJP Sales: " + jpSales
                + "\nOther Sales: " + otherSales
                + "\nGlobal Sales: " + globalSales
                + "\n");
    }
}
