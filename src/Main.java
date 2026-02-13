
import java.util.ArrayList;

/**
Video Game Sales Correlation Coefficient Calculator
 __  __    _    ____  _____   ______   __ 
|  \/  |  / \  |  _ \| ____| | __ ) \ / / 
| |\/| | / _ \ | | | |  _|   |  _ \\ V (_)
| |  | |/ ___ \| |_| | |___  | |_) || | _ 
|_|  |_/_/   \_\____/|_____| |____/ |_|(_)

 ____  _                    _   _ _                              ___   
|  _ \(_)_   _  __ _ _ __  | \ | (_)_   _  __ _ _________   __  ( _ )  
| | | | | | | |/ _` | '__| |  \| | | | | |/ _` |_  / _ \ \ / /  / _ \/\
| |_| | | |_| | (_| | |    | |\  | | |_| | (_| |/ / (_) \ V /  | (_>  <
|____/|_|\__, |\__,_|_|    |_| \_|_|\__, |\__,_/___\___/ \_/    \___/\/
         |___/                      |___/                              

 ___                        _   _                 _    
|_ _|___  __ _  __ _  ___  | \ | | _____   ____ _| | __
 | |/ __|/ _` |/ _` |/ __| |  \| |/ _ \ \ / / _` | |/ /
 | |\__ \ (_| | (_| | (__  | |\  | (_) \ V / (_| |   < 
|___|___/\__,_|\__,_|\___| |_| \_|\___/ \_/ \__,_|_|\_\
                                                       
Mr. Wuest - 3AC Data Structures and Algorithms
*/

public class Main {

    public static void main(String[] args) {

        CSV_Parser parser = new CSV_Parser("assets", "vgsales.csv");
        parser.parseCSV();
        ArrayList<String[]> valuesArray = parser.getValuesArray();


        GameList gameList = new GameList();
        for (String[] values : valuesArray) {
            Game game = new Game(values);
            gameList.addGame(game);
        }

<<<<<<< HEAD
        gameList.printMaps();

        CorrelationCalculator calculator = new CorrelationCalculator(gameList.getGames());
        calculator.printCorrelationCoefficients();

        String[] values = {"Rank", "Year", "NA Sales", "EU Sales", "JP Sales", "Other Sales", "Global Sales"};
        double[][] correlationCoefficients = calculator.getCorrelationCoefficients();
        Display.draw(correlationCoefficients, values);
=======
         CorrelationCalculator calculator = new CorrelationCalculator(gameList.getGames());
         calculator.printCorrelationCoefficients();

        // String[] values = { "Rank", "Year", "NA Sales", "EU Sales", "JP Sales", "Other Sales", "Global Sales" };

        // CorrelationCalculator.printCorrelationCoefficients();

>>>>>>> parent of d6fbca4 (Fully Functional)
    }

}
