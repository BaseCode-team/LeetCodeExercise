package base.utils.random;

import java.util.HashSet;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-06-27 20:13
 * @description Random Utils
 */
public class Random {
    /**
     * 生成指定范围内N个不重复的数 此处采取最简单的双重循环去重
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] nums = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int)(Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j : nums) {
                if (num == j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nums[count++] = num;
            }
        }
        return nums;
    }

    /**
     * 生成指定范围内N个不重复的数
     * 
     * @Param min指定范围最小值
     * @Param max指定范围最大值
     * @Param n随机数个数 这里利用HashSet的特性，只能存放不同的值达到无重复的效果
     */
    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int num = (int)(Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        // 如果存入数小于指定生成的个数，则递归调用再生成剩余个数的随机数，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);
        }
    }

}
