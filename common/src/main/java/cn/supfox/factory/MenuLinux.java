package cn.supfox.factory;

public class MenuLinux extends Menu{

    private String color;

    private int width;

    public MenuLinux(String color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print() {
        System.out.println("linux菜单颜色:"+color + "  宽度:"+width);
    }
}
