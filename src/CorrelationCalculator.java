
import java.util.ArrayList;
import java.util.Arrays;

public class CorrelationCalculator<T> {

    private final int size;
    private static double[][] correlationCoefficients;

    public CorrelationCalculator(ArrayList<T> objectArrayList) {
        this.size = 6;
        correlationCoefficients = new double[7][7];
        populateCorrelationCoefficients();
    }

    public void populateCorrelationCoefficients() {
        boolean works = false;
        double xSum = 0;
        double ySum = 0;
        double xySum = 0;

        int row = 0;
        int col = 0;
        for (Value value1 : Value.values()) {
            for (Value value2 : Value.values()) {
                if (value1.isNumeric() && value2.isNumeric()) {
                    works = true;
                    if (value1 != value2) {
                        if (value1.isNumeric()) {
                            xSum += GameList.getSums().get(value1);
                        } else {
                            // nothing
                        }
                        if (value2.isNumeric()) {
                            ySum += GameList.getSums().get(value2);
                        } else {
                            // nothing
                        }
                        xySum += GameList.getSums().get(value1) * GameList.getSums().get(value2);
                    }
                } else {
                    works = false;
                }
                System.out.println("ROW: " + row + " COL: " + col);
                correlationCoefficients[row][col] = calculate(xSum, ySum, xySum);
                if (works) {
                    col++;
                }
            }
            col = 0;
            if (works) {
                row++;
            }
        }
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
     * Σx² and Σy² are the sums of the squares of x and y values.
     */
    public double calculate(double xSum, double ySum, double xySum) {
        double xSumSquared = Math.pow(xSum, 2);
        double ySumSquared = Math.pow(ySum, 2);

        double numerator = size * xySum - xSum * ySum;
        double denominator = (Math.sqrt(size * xSumSquared) - Math.pow(xSum, 2))
                * (size * ySumSquared - Math.pow(ySum, 2));

        return numerator / denominator;
    }

    public double[][] getCorrelationCoefficients() {
        for(int i = 0; i < correlationCoefficients.length; i++) {
            for(int j = 0; j < correlationCoefficients[i].length; j++) {
                correlationCoefficients[i][j] *= Math.pow(10,17);
            }
        }
        return correlationCoefficients;
    }

    public static void printCorrelationCoefficients() {
        for (double[] row : correlationCoefficients) {
            System.out.println(Arrays.toString(row));
        }
    }
}
