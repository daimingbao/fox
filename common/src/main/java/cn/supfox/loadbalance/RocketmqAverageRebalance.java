package cn.supfox.loadbalance;


import java.util.ArrayList;
import java.util.List;

public class RocketmqAverageRebalance {

    public static void main(String[] args) {
        //消费者数量
        List<String> cidAll = new ArrayList<>();
        cidAll.add("126");
        cidAll.add("127");
        cidAll.add("128");
        cidAll.add("129");
        cidAll.add("130");
        String currentCID = "130";
        int index = cidAll.indexOf(currentCID);
        //消息队列数量
        List<String> mqAll = new ArrayList<>();
        mqAll.add("1");
        mqAll.add("2");
        mqAll.add("3");
        mqAll.add("4");

        List<String> result = new ArrayList<>();
        // 消息队列%消费者 是否能够正好整数倍分配完整
        int mod = mqAll.size() % cidAll.size();
        //平均每个消费者消费的队列大小
        int averageSize = 0;

        //计算当前消费者需要消费的队列大小
        //如果需要消费的队列数 小于 消费者数量 则每个（编号小于队列编号的）消费者需要消费1个队列
        if (mqAll.size() <= cidAll.size()) {
            averageSize = 1;
        } else {
            //如果队列不能被正好整数被分配完，并且当前消费者需要比整数个消费多一个
            if (mod > 0 && index < mod) {
                averageSize = mqAll.size() / cidAll.size() + 1;
            } else {
                ////如果队列不能被正好整数被分配完，并且当前消费者不需要比整数个消费多一个（当前消费者消费队列数不加1），刚好消费整数个
                averageSize = mqAll.size() / cidAll.size();
            }
        }
//        int averageSize =
//                mqAll.size() <= cidAll.size() ? 1 : (mod > 0 && index < mod ? mqAll.size() / cidAll.size()
//                        + 1 : mqAll.size() / cidAll.size());

        //计算消费者需要开始消费的队列下标。
        int startIndex;
        //消费者不能正好整数倍消费完成，并且需要多消费一个队列的情况下 比如是第3个消费者 平均大小是1 则开始位置是2*1=2
        if (mod > 0 && index < mod) {
            startIndex = index * averageSize;
        } else {
            // 总共3个队列 2个消费者 mode = 1    则第2个消费者的开始位置为 1*1 + 1 = 2
            startIndex = index * averageSize + mod;
        }
//         startIndex = (mod > 0 && index < mod) ? index * averageSize : index * averageSize + mod;
        //消费队列的范围  总共3个队列 2个消费者 mode = 1    则第2个消费者的开始位置为 1*1 + 1 = 2
        //如果消费者需要消费的数量不会加1 则消费范围为averageSize, 但是也可能存在一个消费者
        System.out.println(mqAll.size() - startIndex);
        System.out.println(averageSize);
        //范围比较 存在一种情况 消费者数量比队列数量多的情况 存在部分消费者消费不到队列情况，
        // 则会使得 averageSize=1 但是 （mqAll.size() - startIndex） =0的情况 这样就范围就是0了。
        int range = Math.min(averageSize, mqAll.size() - startIndex);
        for (int i = 0; i < range; i++) {
            //按范围获取队列，保证连续性质
            result.add(mqAll.get((startIndex + i) % mqAll.size()));
        }


    }
}
