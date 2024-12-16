// 游乐设施类实现 RideInterface 接口
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Ride implements RideInterface {
    // 定义私有字段
    private String name; // 游乐设施名称
    private String type; // 游乐设施类型
    private Employee operator; // 操作员
    private final Queue<Visitor> waitingLine = new LinkedList<>(); // 等待队列
    private final List<Visitor> rideHistory = new LinkedList<>(); // 游乐记录
    private int maxCycleCapacity; // 每次运行的最大容量
    private int numOfCycles; // 已运行的循环次数

    // 默认构造函数
    public Ride() {
        // 默认构造方法，无参数
    }

    // 带参数的构造函数，用于初始化游乐设施
    public Ride(String name, String type, Employee operator, int maxCycleCapacity) {
        this.name = name; // 初始化名称
        this.type = type; // 初始化类型
        this.operator = operator; // 设置操作员
        this.maxCycleCapacity = maxCycleCapacity; // 设置最大容量
        this.numOfCycles = 0; // 初始化循环次数为 0
    }

    // 获取游乐设施名称
    public String getName() {
        return name;
    }

    // 设置游乐设施名称
    public void setName(String name) {
        this.name = name;
    }

    // 获取游乐设施类型
    public String getType() {
        return type;
    }

    // 设置游乐设施类型
    public void setType(String type) {
        this.type = type;
    }

    // 获取操作员
    public Employee getOperator() {
        return operator;
    }

    // 设置操作员
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // 获取每次运行的最大容量
    public int getMaxCycleCapacity() {
        return maxCycleCapacity;
    }

    // 设置每次运行的最大容量
    public void setMaxCycleCapacity(int maxCycleCapacity) {
        this.maxCycleCapacity = maxCycleCapacity;
    }

    // 获取已运行的循环次数
    public int getNumOfCycles() {
        return numOfCycles;
    }

    // 将游客添加到等待队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    // 从等待队列中移除游客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (waitingLine.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " is not in the queue.");
        }
    }

    // 打印等待队列
    @Override
    public void printQueue() {
        System.out.println("Waiting Line: ");
        if (waitingLine.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            waitingLine.forEach(visitor -> System.out.println(visitor.getName()));
        }
    }

    // 运行一次游乐设施循环
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }

        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }

        System.out.println("Running one cycle of the ride...");
        int count = 0;
        while (!waitingLine.isEmpty() && count < maxCycleCapacity) {
            Visitor visitor = waitingLine.poll();
            if (visitor != null) {
                addVisitorToHistory(visitor);
                System.out.println(visitor.getName() + " has taken the ride.");
                count++;
            }
        }
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
    }

    // 将游客添加到游乐记录
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to ride history.");
    }

    // 检查游客是否在游乐记录中
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // 获取总游客数量
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // 打印游乐记录
    @Override
    public void printRideHistory() {
        System.out.println("Ride History: ");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history.");
        } else {
            rideHistory.forEach(visitor -> System.out.println(visitor.getName()));
        }
    }

    // 按指定比较器排序游乐记录
    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
        System.out.println("Ride history sorted.");
    }

    // 导出游乐记录到文件
    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toString());
                writer.newLine();
            }
            System.out.println("Ride history exported successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    // 从文件导入游乐记录
    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rideHistory.add(Visitor.fromString(line));
            }
            System.out.println("Ride history imported successfully from " + filePath);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }

    // 清空游乐记录
    public void clearRideHistory() {
        rideHistory.clear();
        System.out.println("Ride history cleared.");
    }
}
