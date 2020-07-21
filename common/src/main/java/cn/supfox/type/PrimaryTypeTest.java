package cn.supfox.type;

/**
 * @author dmb
 * @since 2020/1/6
 */
public class PrimaryTypeTest {

    private  static char a;

    public static void main(String[] args) {
        new D();
        System.out.println((int)Character.valueOf(a));

        String str = new String("ewew");
        String s = "a";
    }

}

interface A{

}

interface B{



}

interface C extends A, B{

    void show();

}

class D implements C {

    @Override
    public void show() {
        System.out.println("a");
    }
}
