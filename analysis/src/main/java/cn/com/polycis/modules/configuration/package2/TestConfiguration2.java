package cn.com.polycis.modules.configuration.package2;


public class TestConfiguration2 {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestConfiguration{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
