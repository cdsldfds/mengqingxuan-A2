// 游客类 Visitor，继承自抽象类 Person
class Visitor extends Person {
    // 私有字段：票种和访问次数
    private String ticketType; // 游客的票种
    private int visitCount; // 游客的访问次数

    // 默认构造函数
    public Visitor() {
        // 默认构造方法，无参数
    }

    // 带参数的构造函数，用于初始化游客信息
    public Visitor(String name, int age, String address, String ticketType, int visitCount) {
        super(name, age, address); // 调用父类构造函数初始化姓名、年龄和地址
        this.ticketType = ticketType; // 初始化票种
        this.visitCount = visitCount; // 初始化访问次数
    }

    // 获取票种
    public String getTicketType() {
        return ticketType;
    }

    // 设置票种
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // 获取访问次数
    public int getVisitCount() {
        return visitCount;
    }

    // 设置访问次数
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    // 返回游客信息的字符串表示，格式为 CSV
    @Override
    public String toString() {
        return getName() + "," + getAge() + "," + getAddress() + "," + ticketType + "," + visitCount;
    }

    // 从字符串解析游客信息，CSV 格式
    public static Visitor fromString(String csvLine) {
        String[] parts = csvLine.split(","); // 按逗号分割字符串
        return new Visitor(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], Integer.parseInt(parts[4]));
    }
}
