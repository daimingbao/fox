package cn.supfox.factory;

public class LinuxFactory implements AbstractFactory
{
    @Override
    public Button createButton(String color, int width, int height) {
        return new ButtonLinux(color, width, height);
    }

    @Override
    public Menu createMenu(String color, int width) {
        return new MenuLinux(color, width);
    }

    @Override
    public ScrollBars createScrollBars(String color, int heigth) {
        return new ScrollBarsLinux(color, heigth);
    }
}
