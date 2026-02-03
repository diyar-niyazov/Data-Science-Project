// Created by Diyar Niyazov and Isaac Novak

public class Game {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private int na_sales;
    private int eu_sales;
    private int jp_sales;
    private int other_sales;
    private int global_sales;

    public Game(String name,
            int rank,
            String platform,
            int year,
            String genre,
            String publisher,
            int na_sales,
            int eu_sales,
            int jp_sales,
            int other_sales,
            int global_sales) {
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

    public int getNa_sales() {
        return na_sales;
    }

    public int getEu_sales() {
        return eu_sales;
    }

    public int getJp_sales() {
        return jp_sales;
    }

    public int getOther_sales() {
        return other_sales;
    }

    public int getGlobal_sales() {
        return global_sales;
    }
}
