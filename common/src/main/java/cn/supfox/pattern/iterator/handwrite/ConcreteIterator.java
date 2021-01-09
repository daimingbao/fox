package cn.supfox.pattern.iterator.handwrite;


/**
 * 具体的迭代器实现类，不同的聚合对象所对应的迭代器实现是不一样的 以下示意的是数组聚合对象的迭代器
 */
public class ConcreteIterator implements Iterator {

    /**
     * 持有被迭代的具体的聚合对象
     */
    private ConcreteAggregate aggregate;

    /**
     * 内部索引，记录当前迭代到的位置
     */
    private int index = -1;

    /**
     * 构造方法，传入被迭代的具体的聚合对象
     *
     * @param aggregate 被迭代的具体的聚合对象
     */
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * 移动到聚合对象中第一个元素
     */
    @Override
    public void first() {
        index = 0;

    }

    /**
     * 移动到聚合对象中下一个元素
     */
    @Override
    public void next() {
        if (index < this.aggregate.size()) {
            index += 1;
        }

    }

    /**
     * 判断是否已经移动到聚合对象的最后一个元素
     */
    @Override
    public boolean isDone() {
        if (index == this.aggregate.size()) {
            return true;
        }
        return false;
    }

    /**
     * 获取迭代的当前元素
     */
    @Override
    public Object currentItem() {
        return this.aggregate.get(index);
    }

}
