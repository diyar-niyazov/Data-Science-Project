
import java.math.BigDecimal;

public class CorrelationCoefficient {

    private final int n;
    private final BigDecimal xSum, xSquaredSum, ySum, ySquaredSum, xySum;
    private double r;

    public CorrelationCoefficient(int n, BigDecimal xSum, BigDecimal xSquaredSum, BigDecimal ySum, BigDecimal ySquaredSum, BigDecimal xySum) {
        this.n = n;
        this.xSum = xSum;
        this.xSquaredSum = xSquaredSum;
        this.ySum = ySum;
        this.ySquaredSum = ySquaredSum;
        this.xySum = xySum;
    }

    /*
         * Uses Pearson's Correlation Coefficient to measure linear relationships between fields.
         *
         * Pearson's Correlation Coefficient Formula
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
    public double calculate() {


        BigDecimal numerator = xSum.multiply(BigDecimal.valueOf(n)).subtract(xSum.multiply(ySum));
        BigDecimal denominator = xSquaredSum.multiply(BigDecimal.valueOf(n)).subtract(xSum.pow(2)).multiply(ySquaredSum.multiply(2).subtract(ySum.pow(2)));
        denominator = math.
        System.out.println("NUMERATOR: " + numerator);
        System.out.println("DENOMINATOR: " + denominator);
        r = numerator / denominator;
    }
}

// /**
//  * Mean-Centered Pearson's Correlation Coefficient Formula
//  *
//  * r = Σ[(x_i - x̄)(y_i - ȳ)] / √{[Σ(x_i - x̄)²] [Σ(y_i - ȳ)²]}
//  *
//  * Where:
//  *
//  * xi, yi are the individual data points.
//  *
//  * x̄ = mean of all x values = (Σxi) / n
//  *
//  * ȳ = mean of all y values = (Σyi) / n
//  *
//  * Σ[(xi - x̄)(yi - ȳ)] is the sum of the products of deviations from the
//  * mean.
//  *
//  * Σ(xi - x̄)² and Σ(yi - ȳ)² are the sums of squared deviations from the
//  * mean.
//  *
//  * n is the number of data points.
//  */
// public double caclulateMeanCenteredCorrelationCoefficient() {

    // }
