package enums;

public enum LogicEnum {

    AND("AND", "AND"),
    OR("OR", "OR");

    private String name;
    private String type;

    LogicEnum(String name, String type) {
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
