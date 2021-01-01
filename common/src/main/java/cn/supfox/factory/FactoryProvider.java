package cn.supfox.factory;

public class FactoryProvider {

    public static AbstractFactory getFactory(String osType) {
        if ("linux".equals(osType)) {
            return new LinuxFactory();
        } else if ("windows".equals(osType)) {
            return new WindowsFactory();
        }
        return null;
    }
}
