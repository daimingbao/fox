package cn.supfox.factory;


public abstract class Button {

    private String color;

    private int width;

    private int height;

    public void print() {
        System.out.println("颜色:"+color + "  宽度:"+width + "   高度:"+height);
    }
}
