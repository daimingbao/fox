package com.fox.algorithm;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmb
 * @since 2020/1/13
 */
public class LengthestSubSequence {

    public static void main(String[] args) {

        String[] months = new String[] {"201901", "201912", "201911","201910", "201905"};

        Arrays.sort(months);

        Map<String, Integer> count = new HashMap<>();

        String monthCount = "";
        String month = "";
        for (int i=0; i< months.length; i++) {
            monthCount =  months[i];
            for (int j=i; j<months.length; j++) {
                month = months[j];
                String format = YearMonth.parse(month, DateTimeFormatter.ofPattern("yyyyMM")).plus(1, ChronoUnit.MONTHS)
                        .format(DateTimeFormatter.ofPattern("yyyyMM"));
                if (j < months.length -1 && format.equalsIgnoreCase(months[j+1])) {
                    count.put(monthCount, 1 + count.getOrDefault(monthCount, 0));
                    continue;
                }
                break;
            }
        }

        System.out.println(count);

    }

}
