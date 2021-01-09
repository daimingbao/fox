package cn.supfox.pattern.iterator.handwrite;

/**
 * 具体的聚合对象，实现创建相应迭代器对象的功能
 *
 */
public class ConcreteAggregate extends Aggregate {

    /**
     * 示意，表示聚合对象具体的内容
     */
    private String[] ss = null;

    /**
     * 构造方法，传入聚合对象具体的内容
     *
     * @param ss 聚合对象具体的内容
     */
    public ConcreteAggregate(String[] ss) {
        super();
        this.ss = ss;
    }

    /**
     * 工厂方法，创建相应的迭代器对象的接口
     */
    @Override
    public Iterator createIterator() {
        // 实现创建迭代器的工厂方法
        return new ConcreteIterator(this);
    }

    /**
     * 根据索引位置，获取所对应的元素
     */
    public Object get(int index) {
        Object retObj = null;
        if (index < ss.length) {
            retObj = ss[index];
        }
        return retObj;
    }

    /**
     * 获取聚合对象的容量大小
     */
    public int size() {
        return this.ss.length;
    }

}
