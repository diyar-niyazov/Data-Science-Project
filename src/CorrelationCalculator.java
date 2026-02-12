
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class CorrelationCalculator {

    private ArrayList<Game> games;
    private ArrayList<ArrayList<Double>> correlationCoefficients = new ArrayList<>();

    public CorrelationCalculator(ArrayList<Game> games) {
        this.games = games;
        populateCorrelationCoefficients();
    }

    public void populateCorrelationCoefficients() {
        int n = games.size();
        boolean sameValueAdded = false;

        for (CSV_Category x : CSV_Category.values()) {
            ArrayList<Double> row = new ArrayList<>();
            for (CSV_Category y : CSV_Category.values()) {
                if (x == y && !sameValueAdded) {
                    row.add(1.0);
                    sameValueAdded = true;
                }
                if (x != y) {
                    if (x.isNumeric() && y.isNumeric()) {
                        BigDecimal xSum = BigDecimal.ZERO, xSquaredSum = BigDecimal.ZERO,
                                ySum = BigDecimal.ZERO, ySquaredSum = BigDecimal.ZERO,
                                xySum = BigDecimal.ZERO;
                        for (Game game : games) {
                            double xField = game.getNumericField(x);
                            double yField = game.getNumericField(y);
                            xSum = xSum.add(BigDecimal.valueOf(xField));
                            xSquaredSum = xSquaredSum.add(BigDecimal.valueOf(Math.pow(xField, 2)));
                            ySum = ySum.add(BigDecimal.valueOf(yField));
                            ySquaredSum = ySquaredSum.add(BigDecimal.valueOf(Math.pow(yField, 2)));
                            xySum = xySum.add(BigDecimal.valueOf(xField * yField));
                        }
                        // System.out.println("VALUE 1: " + x + "\nVALUE 2: " + y);
                        // System.out.println("X SUM: " + xSum + "\nX SQUARED SUM: " + xSquaredSum + "\nY SUM: " + ySum + "\nY SQUARED SUM: " + ySquaredSum + "\nXY SUM: " + xySum);
                        row.add(new CorrelationCoefficient(games.size(), xSum, xSquaredSum, ySum, ySquaredSum, xySum).calculate());
                    }
                }
            }
            if (x.isNumeric()) {
                correlationCoefficients.add(row);
            }
            sameValueAdded = false;
        }
        // System.out.println("xSum " + xSum + " xSquaredSum " + xSquaredSum + " ySum " + ySum + " ySquaredSum " + ySquaredSum + " xySum " + xySum);
    }

    public void printCorrelationCoefficients() {
        for (ArrayList<Double> row : correlationCoefficients) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }

    public ArrayList<ArrayList<Double>> getCorrelationCoefficients() {
        return correlationCoefficients;
    }
}
