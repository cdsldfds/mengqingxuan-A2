class Employee extends Person {
    // 定义私有字段：职位和薪资
    private String role; // 职位
    private double salary; // 薪资

    // 默认构造函数
    public Employee() {
        // 默认构造方法，无参数
    }

    // 带参数的构造函数，用于初始化员工信息
    public Employee(String name, int age, String address, String role, double salary) {
        // 调用父类构造函数初始化姓名、年龄和地址
        super(name, age, address);
        this.role = role; // 初始化职位
        this.salary = salary; // 初始化薪资
    }

    // 获取职位
    public String getRole() {
        return role;
    }

    // 设置职位
    public void setRole(String role) {
        this.role = role;
    }

    // 获取薪资
    public double getSalary() {
        return salary;
    }

    // 设置薪资
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

