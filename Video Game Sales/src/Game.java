//vgsales.csv format:
// Rank,Name,Platform,Year,Genre,Publisher,NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales

public class Game {

    private final int rank;
    private final String name;
    private final String platform;
    private final int year;
    private final String genre;
    private final String publisher;
    private final double na_sales;
    private final double eu_sales;
    private final double jp_sales;
    private final double other_sales;
    private final double global_sales;

    public Game(String[] game_values) {
        if (game_values[0].matches("^\\d+$")) {
            this.rank = Integer.parseInt(game_values[0]);
        } else {
            this.rank = -1;
        }
        this.name = game_values[1];
        this.platform = game_values[2];
        if (game_values[3].matches("^\\d+$")) {
            this.year = Integer.parseInt(game_values[3]);
        } else {
            this.year = -1;
        }
        this.genre = game_values[4];
        this.publisher = game_values[5];
        if (game_values[6].matches("^\\d+$|^\\d+\\.\\d+$")) {
            this.na_sales = Double.parseDouble(game_values[6]);
        } else {
            this.na_sales = -1;
        }
        if (game_values[7].matches("^\\d+$|^\\d+\\.\\d+$")) {
            this.eu_sales = Double.parseDouble(game_values[7]);
        } else {
            this.eu_sales = -1;
        }
        if (game_values[8].matches("^\\d+$|^\\d+\\.\\d+$")) {
            this.jp_sales = Double.parseDouble(game_values[8]);
        } else {
            this.jp_sales = -1;
        }
        if (game_values[9].matches("^\\d+$|^\\d+\\.\\d+$")) {
            this.other_sales = Double.parseDouble(game_values[9]);
        } else {
            this.other_sales = -1;
        }
        if (game_values[10].matches("^\\d+$|^\\d+\\.\\d+$")) {
            this.global_sales = Double.parseDouble(game_values[10]);
        } else {
            this.global_sales = -1;
        }
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getPlatform() {
        return platform;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getNa_sales() {
        return na_sales;
    }

    public double getEu_sales() {
        return eu_sales;
    }

    public double getJp_sales() {
        return jp_sales;
    }

    public double getOther_sales() {
        return other_sales;
    }

    public double getGlobal_sales() {
        return global_sales;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Rank: " + rank;
        result += "\nName: " + name;
        result += "\nPlatform: " + platform;
        result += "\nYear: " + year;
        result += "\nGenre: " + genre;
        result += "\nPublisher: " + publisher;
        result += "\nNA Sales: " + na_sales;
        result += "\nEU Sales: " + eu_sales;
        result += "\nJP Sales: " + jp_sales;
        result += "\nOther Sales: " + other_sales;
        result += "\nGlobal Sales: " + global_sales;
        result += "\n";
        return result;
    }
}
