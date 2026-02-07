
public enum Value {
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

    Value(boolean numeric) {
        this.numeric = numeric;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public int index() {
        return this.ordinal();
    }
}
