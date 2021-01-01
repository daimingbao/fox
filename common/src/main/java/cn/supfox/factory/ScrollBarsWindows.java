package cn.supfox.factory;

public class ScrollBarsWindows extends ScrollBars{

    private String color;

    private int height;

    public ScrollBarsWindows(String color, int height) {
        this.color = color;
        this.height = height;
    }


    @Override
    public void print() {
        System.out.println("windows滚动条颜色:"+color + "   高度:"+height);
    }
}
