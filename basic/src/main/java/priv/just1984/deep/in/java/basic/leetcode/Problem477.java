package priv.just1984.deep.in.java.basic.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @description: 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-22 10:54
 */
public class Problem477 {

    public static void main(String[] args) {
        int[] nums = new int[] {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

    public static int totalHammingDistance(int[] nums) {
        /*int total = 0;
        for (int i = 0; i < 32; i++) {
            int check = 1 << i;
            int countZero = 0;
            int countOne = 0;
            for (int num : nums) {
                if ((num & check) == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            total += countOne * countZero;
        }
        return total;*/

        return Stream.iterate(0, i -> i + 1).limit(31).map(i -> 1 << i).reduce(0, (total, check) -> {
            return total + ((int) Arrays.stream(nums).filter(num -> (num & check) == 0).count()) *
                    ((int) Arrays.stream(nums).filter(num -> (num & check) > 0).count());
        });
    }

}
