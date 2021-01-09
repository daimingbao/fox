package cn.supfox.pattern.iterator.handwrite;

/**
 * 迭代器接口，定义访问和遍历元素的操作
 */
public interface Iterator {

    /**
     * 移动到聚合对象中第一个元素
     */
    public void first();

    /**
     * 移动到聚合对象中下一个元素
     */
    public void next();

    /**
     * 判断是否已经移动到聚合对象的最后一个元素
     */
    public boolean isDone();

    /**
     * 获取迭代的当前元素
     */
    public Object currentItem();

}
