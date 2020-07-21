package cn.supfox.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinarySearchSqrtTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException {
        int start = 0;
        int middle = 26 / 2;
        int end = 36;

        val(0, 81, 0.1);


        /**
         * *
         *      * 用Java实现shell命令cat 1.log | grep a | sort | uniq -c | sort -rn的功能
         *      *
         *      *    2 111
         *      *    1 999
         *      *    1 777
         *      *    1 666
         *      *    1 555
         *      *    1 333
         *      *    1 222
         *      *    1 1111
         *      *
         */
        File fileDirectory = new File("/usr/local/");
        List<String> logFiles = new ArrayList<>();
        if (fileDirectory.isDirectory()) {
            File[] files = fileDirectory.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[0];
                if (file.getName().endsWith(".log")) {
                    logFiles.add(file.getAbsolutePath());
                }
            }
        }

        int size = logFiles.size();
        int partitionCount = size % 3 == 0 ? size / 3 : (size / 3 + 1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //String s = logFiles.get(0);
        File file = new File("/Users/paul/1.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        List<String> fileContent = new ArrayList<>();
        String s1 = buffer.readLine();
        fileContent.add(s1);
        while (s1 != null) {
            s1 = buffer.readLine();
            fileContent.add(s1);
        }
/**
 * 4.501139000058174
 * 2111
 * 1999
 * 1777
 * 1666
 * 1555
 * 1333
 * 1222
 * 11111
 */
        List<String> s3 = new ArrayList<>();
        fileContent.stream().filter(Objects::nonNull)
                .sorted().collect(Collectors.groupingBy(Function.identity()))
                .forEach((s2, strings) -> {
                    s3.add(strings.size() + s2);
                });

        List<String> sorted = s3.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        sorted.forEach(System.out::println);
//        System.out.println(sorted);


        RandomAccessFile ras = new RandomAccessFile(file, "r");
        ras.readLine();

    }


    /**
     * @param start  开始值
     * @param end    结束值
     * @param offset 精度值
     * @return
     */
    public static void val(int start, int end, double offset) {


        double middle = end / 2;
        double val = end;
        double v1 = end;
        double v2 = start;
        double temp_offset = 2 * offset;
        while (temp_offset > offset) {
            double temp = middle * middle;
            if (temp == val) {
                break;
            }
            if (temp > val) {
                v2 = 0;
                v1 = middle;
                temp_offset = temp - val;
            } else {
                v2 = middle;
                temp_offset = val - temp;
            }
            middle = (v1 + v2) / 2;
        }

        System.out.println(middle);

    }


}
