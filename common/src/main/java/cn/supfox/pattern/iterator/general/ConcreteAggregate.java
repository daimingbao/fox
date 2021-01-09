package cn.supfox.pattern.iterator.general;

import java.util.ArrayList;
import java.util.List;

//具体容器
public class ConcreteAggregate<E> implements IAggregate<E> {
    private List<E> list = new ArrayList<E>();

    public boolean add(E element) {
        return this.list.add(element);
    }

    public boolean remove(E element) {
        return this.list.remove(element);
    }

    public E get(int index)
    {
        return this.list.get(index);
    }

    public Iterator<E> iterator() {
        return new ConcreteIterator<E>(this.list);
    }

    public int size()
    {
        return list.size();
    }
}