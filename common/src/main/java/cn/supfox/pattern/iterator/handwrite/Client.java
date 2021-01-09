package cn.supfox.pattern.iterator.handwrite;

public class Client {
    public void someOperation() {
        // 创建一个数组
        String[] names = { "张三", "李四", "王五" };
        // 创建聚合对象
        ConcreteAggregate aggregate = new ConcreteAggregate(names);
        // 获取聚合对象的迭代器
        Iterator iterator = aggregate.createIterator();
        // 移动到聚合对象中第一个元素
        iterator.first();
        int index = 1;
        // 循环输出聚合对象中的值
        while (!iterator.isDone()) {
            Object obj = iterator.currentItem();
            System.out.println("聚合对象中第" + (index++) + "个元素是：" + obj);
            iterator.next();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.someOperation();
    }
}
