
import java.util.ArrayList;

public class CorrelationCalculator<T> {

    private final int size;
    private double[][] correlationCoefficients;
    private double[] valueSums;
    private double[] valueSquaredSums;

    public CorrelationCalculator(ArrayList<T> objectArrayList) {
        this.size = objectArrayList.size();
        for (int i = 0; i < valueSums.length; i++) {
            valueSquaredSums[i] = Math.pow(valueSums[i], 2);
        }
        correlationCoefficients = new double[valueSums.length][valueSums.length];
    }

    /*
     * Pearson's Correlation Coefficient Formula
     *
     * The most commonly used formula for calculating the correlation coefficient is
     * Pearson's Correlation Coefficient, given by:
     *
     * r = [n(Σxy) - (Σx)(Σy)] / √{[n(Σx²) - (Σx)²] [n(Σy²) - (Σy)²]}
     * 
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
    public double calculate(double xSum, double ySum, double xySum) {
        double xSumSquared = Math.pow(xSum, 2);
        double ySumSquared = Math.pow(ySum, 2);

        double numerator = size * xySum - xSum * ySum;
        double denominator = (Math.sqrt(size * xSumSquared) - Math.pow(xSum, 2)) * (size * ySumSquared - Math.pow(ySum, 2));

        return numerator / denominator;
    }

    //     for(double[] rowValue : correlationCoefficients) {
    //     for(double colValue : rowValue) {
    //     }
    // }
    public double[][] getCorrelationCoefficients() {
        return correlationCoefficients;
    }
}
