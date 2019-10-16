package priv.just1984.deep.in.java.basic.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * @description: 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 *
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-09 19:49
 */
public class Problem874 {

    public static void main(String[] args) {
        int[] commands = {-2,-1,-2,3,7};
        int[][] obstacles = {{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}};
        int res = robotSim(commands, obstacles);
        System.out.println(res);
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        Forward cur = Forward.Y;
        int[] pos = new int[2];
        for (int command : commands) {
            if (command < 1) {
                cur = cur.change(command);
            } else {
                Optional<int[]> crash;
                switch (cur) {
                    case Y:
                        crash = Arrays.stream(obstacles).filter(arr -> arr[0] == pos[0])
                                .filter(arr -> arr[1] > pos[1] && arr[1] <= pos[1] + command)
                                .min(Comparator.comparingInt(arr -> arr[1]));
                        if (crash.isPresent()) {
                            pos[1] = crash.get()[1] - 1;
                        } else {
                            pos[1] += command;
                        }
                        break;
                    case X:
                        crash = Arrays.stream(obstacles).filter(arr -> arr[1] == pos[1])
                                .filter(arr -> arr[0] > pos[0] && arr[0] <= pos[1])
                                .min(Comparator.comparingInt(arr -> arr[0]));
                        if (crash.isPresent()) {
                            pos[0] = crash.get()[0] - 1;
                        } else {
                            pos[0] += command;
                        }
                        break;
                    case NY:
                        crash = Arrays.stream(obstacles).filter(arr -> arr[0] == pos[0])
                                .filter(arr -> arr[1] < pos[1] && arr[1] >= pos[1] - command)
                                .max(Comparator.comparingInt(arr -> arr[1]));
                        if (crash.isPresent()) {
                            pos[1] = crash.get()[1] + 1;
                        } else {
                            pos[1] -= command;
                        }
                        break;
                    case NX:
                        crash = Arrays.stream(obstacles).filter(arr -> arr[1] == pos[1])
                                .filter(arr -> arr[0] < pos[0] && arr[0] >= pos[0] - command)
                                .max(Comparator.comparingInt(arr -> arr[0]));
                        if (crash.isPresent()) {
                            pos[0] = crash.get()[0] + 1;
                        } else {
                            pos[0] -= command;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return pos[0] * pos[0] + pos[1] * pos[1];
    }

    private enum Forward {
        Y,
        X,
        NY,
        NX;

        public Forward change(int command) {
            if (command == -2) {
                return turnLeft();
            }
            if (command == -1) {
                return turnRight();
            }
            return this;
        }

        private Forward turnRight() {
            return Forward.values()[(this.ordinal() + 1) % 4];
        }

        private Forward turnLeft() {
            return Forward.values()[(this.ordinal() + 3) % 4];
        }
    }

}
