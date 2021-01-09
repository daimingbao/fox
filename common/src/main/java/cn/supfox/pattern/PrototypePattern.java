package cn.supfox.pattern;

import lombok.Getter;
import lombok.Setter;

public class PrototypePattern {

    @Setter
    @Getter
    private static class Student implements Cloneable {

        private String name;

        private Object obj;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setName("dmb");
        student.setObj("a");
        Student clone =(Student) student.clone();
        student.setObj("c");

        System.out.println(student == clone);
        System.out.println(student.getName());
        System.out.println(clone.getName());
        System.out.println(clone.getObj());
    }
}
