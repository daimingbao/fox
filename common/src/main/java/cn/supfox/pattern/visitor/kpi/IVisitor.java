package cn.supfox.pattern.visitor.kpi;

/**
 * Created by Tom.
 */
public interface IVisitor {
    //动态但分派

    void visit(Engineer engineer);

    void visit(Manager manager);

}
