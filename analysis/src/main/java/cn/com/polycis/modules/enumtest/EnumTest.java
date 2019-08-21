package cn.com.polycis.modules.enumtest;

public enum EnumTest {

    db1("db1"),
    db2("db2"),
    db3("db3");

    private String value;
    EnumTest(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }


}
