
import java.util.ArrayList;

// Made by Diyar Niyazov and Isaac Novak
// For Mr. Wuest's 3AC Data Structures and Algorithms

public class Main {

    public static void main(String[] args) {

        ArrayList<String[]> valuesArray = new CSV_Parser("vgsales.csv").getValueArray();
        for (String[] values : valuesArray) {
            Game newGame = new Game(values);
            newGame.printGame();
            GameList.addGame(new Game(values));
        }

        // CorrelationCalculator calculator = new CorrelationCalculator(gameArray);
        // double[][] correlationCoefficients = calculator.getCorrelationCoefficients();
        // display(correlationCoefficients,valuesArray);
    }

    // private static void display(double[][] corrCoeffs, ArrayList<String> variableNames) {
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
