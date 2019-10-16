package priv.just1984.deep.in.java.basic.leetcode;

/**
 * @description: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 *
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 17:06
 */
public class Problem718 {

    public static void main(String[] args) {
        int[] A = {0,0,0,0,1};
        int[] B = {1,0,0,0,0};
        System.out.println(findLength(A, B));
    }

    public static int findLength(int[] A, int[] B) {
        int res = 0;
        int[][] temp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    temp[i + 1][j + 1] = temp[i][j] + 1;
                    res = Math.max(res, temp[i + 1][j + 1]);
                }
            }
        }
        return res;
    }

}
