package cn.supfox.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String time = scanner.nextLine();

        String[] timeStr = time.split(":");

        int[] times = new int[4];
        times[0] = timeStr[0].toCharArray()[0];
        times[1] = timeStr[0].toCharArray()[1];
        times[2] = timeStr[1].toCharArray()[0];
        times[3] = timeStr[1].toCharArray()[1];

        int lasttime = times[3];
        Arrays.sort(times);

        int i = Arrays.binarySearch(times, lasttime);
        if (i != 3) {
            int time1 = times[i + 1];
            char[] chars = timeStr[1].toCharArray();
            chars[1] = (char) time1;
            System.out.println(timeStr[0] + ":" + new String(chars));
        }


    }

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        String str = sc.nextLine();
//        int num = sc.nextInt();
//
//        String[] vlans = str.split(",");
//        Map<String, String> startEnd = new TreeMap<>();
//        for (String vlan : vlans) {
//            if (vlan.contains("-")) {
//                startEnd.put(vlan.split("-")[0], vlan.split("-")[1]);
//            } else {
//                startEnd.put(vlan, "@");
//            }
//        }
//        //移除数据
//        Map<String, String > temp = new HashMap<>();
//        AtomicReference<String> key = new AtomicReference<>("");
//        startEnd.entrySet().forEach( entry -> {
//            String start = entry.getKey();
//            String end = entry.getValue();
//            if (end.equals("@") && start.equals(num+"")) {
//                key.set(num + "");
//            } else {
//                if (!end.equals("@")) {
//                    int i = Integer.parseInt(start);
//                    int j = Integer.parseInt(end);
//                    if (i == num) {
//                        key.set(start);
//
//                        temp.put((i+1)+"",j+"");
//                    }
//                    if (j == num) {
//                        key.set(end);
//
//                        temp.put(i+"",(j-1)+"");
//                    }
//                    if (num > i &&  num < j) {
//                       key.set(num+"");
//
//                       int t1 = num+1;
//                       temp.put(t1+"",j+"");
//                       temp.put(i+"", (num-1)+"");
//
//                    }
//                }
//            }
//        });
//
//
//        if (key.get() != null && key.get().length() > 0 ){
//            startEnd.remove(key.get());
//        }
//        startEnd.putAll(temp);
//
//        StringBuffer sb = new StringBuffer();
//        List<Integer> list = new ArrayList<>();
//        startEnd.forEach((start, end) -> {
//            list.add(Integer.parseInt(start));
//        });
//
//        Collections.sort(list);
//        list.forEach(a -> {
//            String result = startEnd.get(a + "");
//            if (result.equals("@") || result.equals(a+"")) {
//                sb.append(a).append(",");
//            } else {
//                sb.append(a).append("-").append(result).append(",");
//            }
//        });
//        String s = sb.toString();
//        if (s.endsWith(",")){
//           s = s.substring(0, s.length()-1);
//        }
//        System.out.println(s);
//
//    }


//    public static void main(String args[]) {
//        String str = "abcdefghijklmnopqrstuvwxyz";
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < num; i++) {
//            String entry = sc.nextLine();
//            int len = entry.length();
//            int offset = 0;
//            int a = 1;
//            int b = 2;
//            int c = 4;
//            StringBuffer result = new StringBuffer();
//            for (int n = 0; n < len; n++) {
//                if (n == 0) {
//                    offset = 1;
//                } else if (n == 1) {
//                    offset = 2;
//                } else if (n == 2) {
//                    offset = 4;
//                } else {
//                    int temp = a + b + c;
//                    a = b;
//                    b = c;
//                    c = temp;
//                    offset = c;
//                    if(a >= 26) {
//                        a = a %26;
//                    }
//                    if (b >= 26) {
//                        b = b% 26;
//                    }
//                    if (c >= 26 ) {
//                        c = c%26;
//                    }
//                }
//                //根据偏移量获密文字符
//                Character ch = entry.toCharArray()[n];
//                // 26
//                int index = str.indexOf(ch);
//                System.out.println(index);
//                System.out.println(offset);
//                if(offset >= 26) {
//                    offset = offset % 26;
//                }
//                int newIndex = (index + offset) >= 26 ? (index + offset) % 26 : (index + offset);
//                System.out.println(newIndex);
//                result.append(str.toCharArray()[newIndex]);
//
//            }
//            System.out.println(result);
//        }
//    }

}
