package cn.supfox.util;

public interface CommonUtils {

    int SYSTEM_PROCESSORS = Runtime.getRuntime().availableProcessors();

    long SYSTEM_FREE_MEMORY = Runtime.getRuntime().freeMemory();

}
