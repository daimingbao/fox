package cn.supfox.factory;

public interface AbstractFactory {

   Button createButton(String color, int width, int height);

   Menu createMenu(String color , int width);

   ScrollBars createScrollBars(String color, int heigth);
}
