package cn.supfox.factory;

public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory linuxFactory = FactoryProvider.getFactory("linux");
        Button button = linuxFactory.createButton("灰色", 2, 1);
        button.print();
        Button button1 = linuxFactory.createButton("蓝色", 2, 2);
        button1.print();

        Menu menu = linuxFactory.createMenu("透明", 10);
        menu.print();
    }
}
