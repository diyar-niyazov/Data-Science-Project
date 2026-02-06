
public class Game {

    private final int RANK = 0;
    private final int NAME = 1;
    private final int PLATFORM = 2;
    private final int YEAR = 3;
    private final int GENRE = 4;
    private final int PUBLISHER = 5;
    private final int NA_SALES = 6;
    private final int EU_SALES = 7;
    private final int JP_SALES = 8;
    private final int OTHER_SALES = 9;
    private final int GLOBAL_SALES = 10;

    private final Integer rank;
    private final String name;
    private final String platform;
    private final Integer year;
    private final String genre;
    private final String publisher;
    private final Double naSales;
    private final Double euSales;
    private final Double jpSales;
    private final Double otherSales;
    private final Double globalSales;

    private static final double[] valueSums = new double[10];

    public Game(String[] values) {
        Integer r = parseInt(values[RANK]);
        if (r != null) {
            valueSums[RANK] += r;
        }
        rank = r;

        Integer y = parseInt(values[YEAR]);
        if (y != null) {
            valueSums[YEAR] += y;
        }
        year = y;

        Double na = parseDouble(values[NA_SALES]);
        if (na != null) {
            valueSums[NA_SALES] += na;
        }
        naSales = na;

        Double eu = parseDouble(values[EU_SALES]);
        if (eu != null) {
            valueSums[EU_SALES] += eu;
        }
        euSales = eu;

        Double jp = parseDouble(values[JP_SALES]);
        if (jp != null) {
            valueSums[JP_SALES] += jp;
        }
        jpSales = jp;

        Double other = parseDouble(values[OTHER_SALES]);
        if (other != null) {
            valueSums[OTHER_SALES] += other;
        }
        otherSales = other;

        Double global = parseDouble(values[GLOBAL_SALES]);
        if (global != null) {
            valueSums[GLOBAL_SALES] += global;
        }
        globalSales = global;

        name = values[NAME];
        platform = values[PLATFORM];
        genre = values[GENRE];
        publisher = values[PUBLISHER];
    }

    public Integer parseInt(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return null;
        }
    }

    public Double parseDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += "Rank: " + rank;
        result += "\nName: " + name;
        result += "\nPlatform: " + platform;
        result += "\nYear: " + year;
        result += "\nGenre: " + genre;
        result += "\nPublisher: " + publisher;
        result += "\nNA Sales: " + naSales;
        result += "\nEU Sales: " + euSales;
        result += "\nJP Sales: " + jpSales;
        result += "\nOther Sales: " + otherSales;
        result += "\nGlobal Sales: " + globalSales;
        result += "\n";
        return result;
    }

    public static double[] getValueSums() {
        return valueSums;
    }
}
