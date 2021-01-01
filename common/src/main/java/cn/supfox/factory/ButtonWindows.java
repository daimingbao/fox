package cn.supfox.factory;

public class ButtonWindows extends Button {

    private String color;

    private int width;

    private int height;

    public ButtonWindows(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("windows按钮颜色:"+color + "  宽度:"+width + "   高度:"+height);
    }

}
