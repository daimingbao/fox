package cn.supfox.factory;

public class ScrollBarsLinux extends ScrollBars{
    private String color;

    private int height;

    public ScrollBarsLinux(String color, int height) {
        this.color = color;
        this.height = height;
    }


    @Override
    public void print() {
        System.out.println("linux滚动条颜色:"+color + "   高度:"+height);
    }
}
