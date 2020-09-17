package enums;

public enum OperatorEnum {

    EQ("EQ", "="),
    DESC("DESC", "DESC"),
    ACS("ACS", "ACS"),
    LIMIT("LIMIT", "LIMIT"),
    NOTEQ("NOTEQ", "!=");

    private String name;
    private String val;

    OperatorEnum(String name, String val) {
        this.name = name;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public String getVal() {
        return val;
    }
}
