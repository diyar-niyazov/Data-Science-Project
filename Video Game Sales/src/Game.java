// Created by Diyar Niyazov and Isaac Novak
// Rank,Name,Platform,Year,Genre,Publisher,NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales
public class Game {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double na_sales;
    private double eu_sales;
    private double jp_sales;
    private double other_sales;
    private double global_sales;

    public Game(String[] game_values) {
        this.rank = Integer.parseInt(game_values[0]);
        this.name = game_values[1];
        this.platform = game_values[2];
        if (!game_values[3].equals("N/A"))
            this.year = Integer.parseInt(game_values[3]);
        this.genre = game_values[4];
        this.publisher = game_values[5];
        if (!game_values[6].equals("N/A"))
            this.na_sales = Double.parseDouble(game_values[6]);
        if (!game_values[7].equals("N/A"))
            this.eu_sales = Double.parseDouble(game_values[7]);
        if (!game_values[8].equals("N/A"))
            this.jp_sales = Double.parseDouble(game_values[8]);
        if (!game_values[9].equals("N/A"))
            this.other_sales = Double.parseDouble(game_values[9]);
        if (!game_values[10].equals("N/A"))
            this.global_sales = Double.parseDouble(game_values[10]);
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
}
