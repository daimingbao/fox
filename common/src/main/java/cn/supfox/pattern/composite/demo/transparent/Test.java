package cn.supfox.pattern.composite.demo.transparent;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("============透明组合模式===========");

        CourseComponent javaBase = new Course("Java入门课程",8280);
        CourseComponent ai = new Course("人工智能",5000);

        CourseComponent packageCourse = new CoursePackage("Java架构师课程",2);

        CourseComponent design = new Course("Java设计模式",1500);
        CourseComponent source = new Course("源码分析",2000);
        CourseComponent softSkill = new Course("软技能",3000);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        ai.addChild(javaBase); //违背了最少知道原则，所以有了安全模式的写法

        /**
         * CoursePackage和Course都继承了CourseComponent，那么Course也有了CoursePackage对应的方法<br>
         * Course具有不该具备的方法addChild()，那么就违背了最少知道原则<br>
         */

        CourseComponent catalog = new CoursePackage("课程主目录",1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();
    }
}
