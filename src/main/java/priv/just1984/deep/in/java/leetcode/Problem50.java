package priv.just1984.deep.in.java.leetcode;

import java.util.stream.Stream;

import static sun.net.ftp.FtpReplyCode.find;

/**
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 17:06
 */
public class Problem50 {

    public static void main(String[] args) {
        System.out.println(myPow(1d, -2147483648));
    }

    public static double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1d;
        while (N > 0) {
            if ((N & 1) == 1) {
                ans *= x;
            }
            x = x * x;
            N = N >> 1;
        }
        return ans;
    }

}
