// 抽象类 Person
abstract class Person {
    // 定义私有字段：姓名、年龄和地址
    private String name; // 姓名
    private int age; // 年龄
    private String address; // 地址

    // 默认构造函数
    public Person() {
        // 默认构造方法，无参数
    }

    // 带参数的构造函数，用于初始化姓名、年龄和地址
    public Person(String name, int age, String address) {
        this.name = name; // 初始化姓名
        this.age = age; // 初始化年龄
        this.address = address; // 初始化地址
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置姓名
    public void setName(String name) {
        this.name = name;
    }

    // 获取年龄
    public int getAge() {
        return age;
    }

    // 设置年龄
    public void setAge(int age) {
        this.age = age;
    }

    // 获取地址
    public String getAddress() {
        return address;
    }

    // 设置地址
    public void setAddress(String address) {
        this.address = address;
    }
}
