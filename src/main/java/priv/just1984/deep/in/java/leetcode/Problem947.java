package priv.just1984.deep.in.java.leetcode;

import java.util.*;
import java.util.function.BiPredicate;

/**
 * @description: 移除最多的同行或同列石头
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 * 我们最多能执行多少次 move 操作？
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 *  
 * 提示：
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 *
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 20:40
 */
public class Problem947 {

    public static void main(String[] args) {
        int[][] stones = new int[][] {
                new int[] {0, 0},
                new int[] {0, 1},
                new int[] {1, 0},
                new int[] {1, 2},
                new int[] {2, 1},
                new int[] {2, 2}
        };
        /*int[][] stones = new int[][] {
                new int[] {0, 0},
                new int[] {0, 2},
                new int[] {1, 1},
                new int[] {2, 0},
                new int[] {2, 2}
        };*/
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        /*int count = 0;
        Arrays.sort(stones, Comparator.<int[]>comparingInt(arr -> arr[0]).thenComparing(arr -> arr[1]));
        int[] pre = stones[0];
        for (int i = 1; i < stones.length; i++) {
            int[] cur = stones[i];
            if (pre[0] == cur[0] || pre[1] == cur[1]) {
                count++;
            } else {
                pre = cur;
            }
        }
        return count;*/

        /*List<int[]> list = new ArrayList<>(Arrays.asList(stones));
        list.sort(Comparator.<int[]>comparingInt(arr -> arr[0]).thenComparing(arr -> arr[1]));
        Iterator<int[]> iterator = list.iterator();
        int[] pre = iterator.next();
        while (iterator.hasNext()) {
            int[] cur = iterator.next();
            if (pre[0] == cur[0] || pre[1] == cur[1]) {
                iterator.remove();
            }
            pre = cur;
        }
        return stones.length - list.size();*/

        List<int[]> list = new ArrayList<>(Arrays.asList(stones));
        Collections.sort(list, Comparator.comparingInt(arr -> arr[0]));
        distinct(list, (x, y) -> x[0] == y[0]);
        Collections.sort(list, Comparator.comparingInt(arr -> arr[1]));
        distinct(list, (x, y) -> x[1] == y[1]);
        return stones.length - list.size();
    }

    private static void distinct(Collection<int[]> collection, BiPredicate<int[], int[]> predicate) {
        Iterator<int[]> iterator = collection.iterator();
        int[] pre = iterator.next();
        while (iterator.hasNext()) {
            int[] cur = iterator.next();
            if (predicate.test(pre, cur)) {
                iterator.remove();
            }
            pre = cur;
        }
    }

}
