package cn.supfox.pattern.visitor.general;

// 抽象元素
public interface IElement {
    void accept(IVisitor visitor);
}