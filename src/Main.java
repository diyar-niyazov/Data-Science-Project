
import java.io.IOException;
import java.util.ArrayList;

// Made by Diyar Niyazov and Isaac Novak
public class Main {

    public static ArrayList<Game> gameArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ArrayList<String[]> valuesArray = new CSV_Parser("vgsales.csv").getValueArray();
        for (String[] values : valuesArray) {
            gameArray.add(new Game(values));
        }

        // double[][] correlationCoefficients = new CorrelationCalculator().getCorrelationCoefficients;

        // display(new double[][] {{-1, 0.3, 0.6}, {0.4, -1, 0.7}, {0.1, 0.9, -1}}, new String[] {"valelelelel1", "val2", "val3"});
    }

    // private static void display(double[][] corrCoeffs, String[] variableNames) {
    //     System.out.print("\t");
    //     for(int i = 0; i < variableNames.length; i ++) {
    //         if(variableNames[i].length() >= 8) {
    //             variableNames[i] = variableNames[i].substring(0, 4) + "...";
    //         }
    //         System.out.print("|\t" + variableNames[i] + "\t");
    //     }
    //     for(int i = 0; i < corrCoeffs.length; i ++) {
    //         System.out.println();
    //         System.out.print(variableNames[i] + "\t");
    //         for(int j = 0; j < corrCoeffs[i].length; j ++) {
    //             if(i == j) {
    //                 System.out.print("|\txxx\t");
    //             } else {
    //                 System.out.print("|\t" + corrCoeffs[i][j] + "\t");
    //             }
    //         }
    //     }
    // }
}
