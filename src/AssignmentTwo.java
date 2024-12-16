// 主类 AssignmentTwo
public class AssignmentTwo {
    public static void main(String[] args) {
        // 创建 AssignmentTwo 对象并调用各个部分的方法
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    // 第三部分：添加访客到队列并打印队列的变化
    public void partThree() {
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", new Employee("Alice", 30, "123 Park St", "Operator", 50000), 2);

        // 创建多个访客对象
        Visitor visitor1 = new Visitor("Jack", 25, "456 Elm St", "Standard", 5);
        Visitor visitor2 = new Visitor("Sharon", 22, "789 Pine St", "Premium", 2);
        Visitor visitor3 = new Visitor("Benny", 28, "101 Oak St", "Standard", 3);
        Visitor visitor4 = new Visitor("Leo", 19, "202 Maple St", "Standard", 1);
        Visitor visitor5 = new Visitor("Nina", 24, "303 Birch St", "Premium", 4);

        // 添加访客到过山车队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 打印初始队列
        System.out.println("Initial Queue:");
        rollerCoaster.printQueue();

        // 从队列中移除一个访客
        System.out.println("Removing a visitor from the queue...");
        rollerCoaster.removeVisitorFromQueue(visitor1);

        // 打印更新后的队列
        System.out.println("Updated Queue:");
        rollerCoaster.printQueue();
    }

    // 第四部分A：添加访客到游玩记录并检查记录
    public void partFourA() {
        Ride thunderstorm = new Ride("Thunderstorm", "Water Ride", new Employee("Bob", 35, "456 Park St", "Operator", 55000), 4);

        // 创建多个访客对象
        Visitor visitor1 = new Visitor("Tom", 26, "456 Elm St", "Standard", 2);
        Visitor visitor2 = new Visitor("Sherly", 21, "789 Pine St", "Premium", 1);
        Visitor visitor3 = new Visitor("Ben", 30, "101 Oak St", "Standard", 3);
        Visitor visitor4 = new Visitor("David", 29, "202 Maple St", "Standard", 4);
        Visitor visitor5 = new Visitor("Linda", 23, "303 Birch St", "Premium", 2);

        // 添加访客到历史记录
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // 检查访客是否在历史记录中
        System.out.println("Checking if Sherly is in ride history: " + thunderstorm.checkVisitorFromHistory(visitor2));
        System.out.println("Number of visitors in history: " + thunderstorm.numberOfVisitors());
        System.out.println("Ride History:");
        thunderstorm.printRideHistory();
    }

    // 第四部分B：对游玩记录进行排序
    public void partFourB() {
        Ride thunderstorm = new Ride("Thunderstorm", "Water Ride", new Employee("Bob", 35, "456 Park St", "Operator", 55000), 4);

        // 创建多个访客对象
        Visitor visitor1 = new Visitor("Tom", 26, "456 Elm St", "Standard", 2);
        Visitor visitor2 = new Visitor("Sherly", 21, "789 Pine St", "Premium", 1);
        Visitor visitor3 = new Visitor("Ben", 30, "101 Oak St", "Standard", 3);
        Visitor visitor4 = new Visitor("David", 29, "202 Maple St", "Standard", 4);
        Visitor visitor5 = new Visitor("Linda", 23, "303 Birch St", "Premium", 2);

        // 添加访客到历史记录
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // 打印排序前的记录
        System.out.println("Ride History Before Sorting:");
        thunderstorm.printRideHistory();

        // 按姓名和年龄排序记录
        thunderstorm.sortRideHistory((v1, v2) -> {
            int nameComparison = v1.getName().compareTo(v2.getName());
            if (nameComparison != 0) return nameComparison;
            return Integer.compare(v1.getAge(), v2.getAge());
        });

        // 打印排序后的记录
        System.out.println("Ride History After Sorting:");
        thunderstorm.printRideHistory();
    }

    // 第五部分：运行一次游乐设施循环
    public void partFive() {
        Ride ferrisWheel = new Ride("Ferris Wheel", "Family", new Employee("Charlie", 40, "789 Park St", "Operator", 50000), 3);

        // 创建多个访客对象
        Visitor visitor1 = new Visitor("Anna", 20, "101 Elm St", "Standard", 1);
        Visitor visitor2 = new Visitor("Brian", 25, "202 Pine St", "Premium", 2);
        Visitor visitor3 = new Visitor("Catherine", 22, "303 Oak St", "Standard", 1);
        Visitor visitor4 = new Visitor("Derek", 28, "404 Maple St", "Standard", 3);
        Visitor visitor5 = new Visitor("Eva", 24, "505 Birch St", "Premium", 1);

        // 添加访客到摩天轮队列
        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);
        ferrisWheel.addVisitorToQueue(visitor4);
        ferrisWheel.addVisitorToQueue(visitor5);

        // 打印初始队列
        System.out.println("Initial Queue:");
        ferrisWheel.printQueue();

        // 运行一次循环
        System.out.println("Running one cycle:");
        ferrisWheel.runOneCycle();

        // 打印循环后的队列
        System.out.println("Queue after one cycle:");
        ferrisWheel.printQueue();

        // 打印游玩记录
        System.out.println("Ride History:");
        ferrisWheel.printRideHistory();
    }

    // 第六部分：导入和导出游玩记录
    public void partSix() {
        Ride ferrisWheel = new Ride("Ferris Wheel", "Family", new Employee("Charlie", 40, "789 Park St", "Operator", 50000), 3);

        // 创建多个访客对象并添加到历史记录
        Visitor visitor1 = new Visitor("Anna", 20, "101 Elm St", "Standard", 1);
        Visitor visitor2 = new Visitor("Brian", 25, "202 Pine St", "Premium", 2);
        Visitor visitor3 = new Visitor("Catherine", 22, "303 Oak St", "Standard", 1);
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);

        String filePath = "ride_history.csv";

        // 导出历史记录到文件
        System.out.println("Exporting ride history to file...");
        ferrisWheel.exportRideHistory(filePath);

        // 清空当前历史记录
        System.out.println("Clearing current ride history...");
        ferrisWheel.clearRideHistory();

        // 从文件导入历史记录
        System.out.println("Importing ride history from file...");
        ferrisWheel.importRideHistory(filePath);

        // 打印导入后的历史记录
        System.out.println("Ride History After Import:");
        ferrisWheel.printRideHistory();
    }

    // 第七部分：从文件中导入并统计访客记录
    public void partSeven() {
        String filePath = "ride_history.csv";
        Ride ferrisWheel = new Ride("Ferris Wheel", "Family", new Employee("Charlie", 40, "789 Park St", "Operator", 50000), 3);

        // 从文件中导入历史记录
        System.out.println("Importing ride history from file...");
        ferrisWheel.importRideHistory(filePath);

        // 打印访客数量和导入后的历史记录
        System.out.println("Number of visitors imported: " + ferrisWheel.numberOfVisitors());
        System.out.println("Ride History After Import:");
        ferrisWheel.printRideHistory();
    }
}
