package enums;

public enum ConiditionEnum {

    WHERE("WHERE", "WHERE"),
    GROUPBY("GROUPBY", "GROUP BY"),
    ORDERBY("ORDERBY", "ORDER BY"),
    LIMIT("LIMIT", "LIMIT");

    private String name;
    private String type;

    ConiditionEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
