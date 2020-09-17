package model;

public class User {
    private String id;
    private String name;
    private Integer age;
    private Integer value;

    public User(String id, String name, Integer age, Integer value) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean equals(User user) {
        if (id.equals(user.getId()) && name.equals(user.getName())
                && age == user.getAge()
                && value == user.getValue()) {
            return true;
        }
        return false;
    }

    public boolean equals(String id, String name, Integer age, Integer value) {
        return this.id == id &&
                this.name == name &&
                this.age == age &&
                this.value == value;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", value=" + value +
                '}';
    }
}