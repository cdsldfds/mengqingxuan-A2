// 游乐设施接口 RideInterface
interface RideInterface {
    // 将游客添加到等待队列
    void addVisitorToQueue(Visitor visitor);

    // 从等待队列中移除游客
    void removeVisitorFromQueue(Visitor visitor);

    // 打印等待队列中的游客信息
    void printQueue();

    // 运行一次游乐设施循环
    void runOneCycle();

    // 将游客添加到游乐记录
    void addVisitorToHistory(Visitor visitor);

    // 检查游客是否在游乐记录中
    boolean checkVisitorFromHistory(Visitor visitor);

    // 获取总游客数量
    int numberOfVisitors();

    // 打印游乐记录
    void printRideHistory();
}

