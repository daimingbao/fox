package cn.supfox.pattern.visitor.kpi;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tom.
 */
public class BusinessReport {
    private List<Employee> employees = new LinkedList<Employee>();

    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Engineer("程序员A"));
        employees.add(new Engineer("程序员B"));
        employees.add(new Engineer("程序员C"));
        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("程序员D"));
    }

    public void showReport(IVisitor visitor){
        //动态多分派，运行时决定
        for (Employee employee : employees) {
            //第一次分派
            employee.accept(visitor);
        }
    }
}
