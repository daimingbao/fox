package cn.supfox.factory;

public class MenuWindows extends Menu{

    private String color;

    private int width;

    public MenuWindows(String color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print() {
        System.out.println("windows菜单颜色:"+color + "  宽度:"+width);
    }
}
