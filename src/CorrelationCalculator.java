
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class CorrelationCalculator {

    private ArrayList<Game> games;
    private ArrayList<ArrayList<Double>> correlationCoefficients;

    public CorrelationCalculator(ArrayList<Game> games) {
        this.games = games;
        populateCorrelationCoefficients();
    }

    public void populateCorrelationCoefficients() {
        int n = games.size();
        BigDecimal xSum = BigDecimal.ZERO, xSquaredSum = BigDecimal.ZERO,
                ySum = BigDecimal.ZERO, ySquaredSum = BigDecimal.ZERO,
                xySum = BigDecimal.ZERO;

        ArrayList<Double> row = new ArrayList<>();

        for (CSV_Category x : CSV_Category.values()) {
            for (CSV_Category y : CSV_Category.values()) {
                if (x != y) {
                    if (x.isNumeric() && y.isNumeric()) {
                        for (Game game : games) {
                            double xField = game.getNumericField(x);
                            double yField = game.getNumericField(y);
                            xSum.add(new BigDecimal(xField));
                            xSquaredSum.add(new BigDecimal(Math.pow(xField, 2)));
                            ySum.add(new BigDecimal(yField));
                            ySquaredSum.add(new BigDecimal(Math.pow(yField, 2)));
                            xySum.add(new BigDecimal(xField * yField));
                        }
                        System.out.println("VALUE 1: " + x + "\nVALUE 2: " + y);
                        System.out.println("X SUM: " + xSum + "\nX SQUARED SUM: " + xSquaredSum + "\nY SUM: " + ySum + "\nY SQUARED SUM: " + ySquaredSum + "\nXY SUM: " + xySum);
                        row.add(new CorrelationCoefficient(games.size(), xSum, xSquaredSum, ySum, ySquaredSum, xySum).calculate());
                    }
                }
            }
            correlationCoefficients.add(row);
        }
        System.out.println("xSum " + xSum + " xSquaredSum " + xSquaredSum + " ySum " + ySum + " ySquaredSum " + ySquaredSum + " xySum " + xySum);
    }

    public void printCorrelationCoefficients() {
        for (ArrayList<Double> row : correlationCoefficients) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
<<<<<<< HEAD

    public double[][] getCorrelationCoefficients() {
        double[][] result = new double[correlationCoefficients.size()][correlationCoefficients.size()];
        for(int i = 0; i < correlationCoefficients.size(); i++) {
            for(int j = 0; j < correlationCoefficients.size(); j++) {
                result[i][j] = correlationCoefficients.get(i).get(j);
            }
        }
        return result;
    }
=======
>>>>>>> parent of d6fbca4 (Fully Functional)
}
