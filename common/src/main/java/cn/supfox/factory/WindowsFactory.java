package cn.supfox.factory;

public class WindowsFactory implements AbstractFactory{
    @Override
    public Button createButton(String color, int width, int height) {
        return new ButtonWindows(color, width, height);
    }

    @Override
    public Menu createMenu(String color, int width) {
        return new MenuWindows(color, width);
    }

    @Override
    public ScrollBars createScrollBars(String color, int heigth) {
        return new ScrollBarsWindows(color, heigth);
    }
}
