package com.ml.toolkit.common.generate;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Random;

/**
 * 生成19位分布式id
 *
 * @author ml
 * 当前id地址随机数 + 当前时间戳随机数+  启动时间戳随机数 + 启动随机数 + 请求次数
 */
public class LongIdGenerator implements Serializable {
    private static final long serialVersionUID = -5250542296573212833L;

    private static int counter = 0;
    private static final int IP_RANDOM_INT;
    private static final int JVM_RANDOM_INT;
    private static final int LAST_RANDOM_INT;

    static {
        long timeMillis = System.currentTimeMillis();
        int ip;
        try {
            ip = toInt(InetAddress.getLocalHost().getAddress());
        } catch (Exception e) {
            ip = 0;
        }
        Random ipRandom = new Random(ip);
        Random jvmRandom = new Random(timeMillis);
        Random lastRandom = new Random();
        IP_RANDOM_INT = ipRandom.nextInt(800) + 100;
        JVM_RANDOM_INT = jvmRandom.nextInt(90) + 10;
        LAST_RANDOM_INT = lastRandom.nextInt(10000);
    }

    public static Long generate() {
        //1970年1月1日0点 到现在的秒数
        long millisecond = System.currentTimeMillis();
        int count = LAST_RANDOM_INT + getCount();
        return (long) IP_RANDOM_INT * 10000000000000000L + millisecond * 100000L + (JVM_RANDOM_INT * 10000L) + (long) count;
    }

    private static int getCount() {
        synchronized (LongIdGenerator.class) {
            if (counter < 0) {
                counter = 0;
            }
            return counter++;
        }
    }

    private static int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; ++i) {
            result = (result << 8) + 128 + bytes[i];
        }
        return result;
    }
}
