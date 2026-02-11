import java.util.Arrays;

public class Game {

    private final String[] values;
    private final Integer rank, year;
    private final String name, platform, genre, publisher;
    private final Double naSales, euSales, jpSales, otherSales, globalSales;

    public Game(String[] values) {
        this.values = values;
        rank = parseInt(Value.RANK);
        year = parseInt(Value.YEAR);
        naSales = parseDouble(Value.NA_SALES);
        euSales = parseDouble(Value.EU_SALES);
        jpSales = parseDouble(Value.JP_SALES);
        otherSales = parseDouble(Value.OTHER_SALES);
        globalSales = parseDouble(Value.GLOBAL_SALES);

        name = values[Value.NAME.index()];
        platform = values[Value.PLATFORM.index()];
        genre = values[Value.GENRE.index()];
        publisher = values[Value.PUBLISHER.index()];
    }

    public Integer parseInt(Value value) {
        try {
            String valueString = values[value.index()];
            return Integer.parseInt(values[value.index()]);
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(values));
            return 0;
        }
    }

    public Double parseDouble(Value value) {
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

    public double getNumericValue(Value value) {
        return switch (value) {
            case RANK ->
                rank == null ? 0 : rank.doubleValue();
            case YEAR ->
                year == null ? 0 : year.doubleValue();
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

    public String getStringValue(Value value) {
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
