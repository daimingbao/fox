package cn.supfox.pattern.prototype;

public class IntegerTest {

    public static void main(String[] args) {
        Integer counter = 0;
        increaseCouter(counter);
        increaseCouter(counter);
        increaseCouter(counter);
        increaseCouter(counter);
        System.out.println("after increase Counter in main,counter=" + counter);
    }

    private static void increaseCouter(Integer counter)
    {

        System.out.println("AAA=" + System.identityHashCode(counter));

        counter = counter +1;

        System.out.println("BBB=" + System.identityHashCode(counter));

        System.out.println("incrreaseCounter==" + counter);
    }
}
