// Created by Diyar Niyazov and Isaac Novak

public class Game {
    private String name;
    private int rank;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double na_sales;
    private double eu_sales;
    private double jp_sales;
    private double other_sales;
    private double global_sales;

    public Game(String name,
            int rank,
            String platform,
            int year,
            String genre,
            String publisher,
            double na_sales,
            double eu_sales,
            double jp_sales,
            double other_sales,
            double global_sales) {
        this.name = name;
        this.rank = rank;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.na_sales = na_sales;
        this.eu_sales = eu_sales;
        this.jp_sales = jp_sales;
        this.other_sales = other_sales;
        this.global_sales = global_sales;
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
