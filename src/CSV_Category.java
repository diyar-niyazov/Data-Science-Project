// Enum representing the different columns/categories in the CSV file.
// Each constant indicates whether the field is numeric (true) or categorical/text (false).
// Provides helper methods to check if a field is numeric and to get its column index in the CSV.

public enum CSV_Category {
    RANK(true),
    NAME(false),
    PLATFORM(false),
    YEAR(true),
    GENRE(false),
    PUBLISHER(false),
    NA_SALES(true),
    EU_SALES(true),
    JP_SALES(true),
    OTHER_SALES(true),
    GLOBAL_SALES(true);

    private final boolean numeric;

    CSV_Category(boolean numeric) {
        this.numeric = numeric;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public int index() {
        return this.ordinal();
    }
}
