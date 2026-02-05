public class CorrelationCoefficient {
    enum Category {
        RANK,
        NAME,
        PLATFORM,
        YEAR,
        GENRE,
        PUBLISHER,
        NA_SALES,
        EU_SALES,
        JP_SALES,
        OTHER_SALES,
        GLOBAL_SALES
    }

    public int correlationcoefficient;
    public int quantity;

    /*
     * Pearson's Correlation Coefficient Formula
     *
     * The most commonly used formula for calculating the correlation coefficient is
     * Pearson's Correlation Coefficient, given by:
     *
     * r = [n(Σxy) - (Σx)(Σy)] / √{[n(Σx²) - (Σx)²] [n(Σy²) - (Σy)²]}
     * Copy
     * Where:
     *
     * n is the number of data points.
     *
     * Σxy is the sum of the product of corresponding x and y values.
     *
     * Σx and Σy are the sums of x and y values, respectively.
     *
     *Σx² and Σy² are the sums of the squares of x and y values.
     */

     public double[][] calculateCorrelationCoefficients() {
        int r;
        int n = 16600;

        int row = 0;
        int column = 0;

        CORRELATION_COEFFICIENTS[row][column] = r;



        return CORRELATION_COEFFICIENTS;
    }

    public double getSum() {
        double rankSum = sigma(RANK);
        double nameSum = sigma(NAME);
        double platformSum = sigma(PLATFORM);
        double yearSum = sigma(YEAR);
        double genreSum = sigma(GENRE);
        double publisherSum = sigma(PUBLISHER);
        double na_salesSum = sigma(NA_SALES);
        double eu_salesSum = sigma(EU_SALES);
        double jp_salesSum = sigma(JP_SALES);
        double other_salesSum = sigma(OTHER_SALES;);
        double global_salesSum = sigma(GLOBAL_SALES);

        return
    }

    public double getSumOfSquares() {

    }

    public double sigma(Category category) {
        double sum = 0;



        for(Game game : games) {

        }
        return sum;
    }
}
