
public class CorrelationCalculator {

    public double[][] correlationCoefficients;
    public double[] valueSums;
    public double[] valueSquaredSums;

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
    
    public void calculate() {
        int r = 0;
        int row = 0;
        int column = 0;
        correlationCoefficients[row][column] = r;
    }

    public double[][] getCorrelationCoefficients() {

        return correlationCoefficients;
    }
}
