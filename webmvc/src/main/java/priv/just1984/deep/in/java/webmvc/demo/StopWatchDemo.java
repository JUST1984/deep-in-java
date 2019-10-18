package priv.just1984.deep.in.java.webmvc.demo;

import org.springframework.util.StopWatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-17 17:55
 */
public class StopWatchDemo {

    private static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws InterruptedException {
        stopWatch.start("process1");
        Thread.sleep(1000);
        stopWatch.stop();
        stopWatch.start("process2");
        Thread.sleep(2000);
        stopWatch.stop();
        stopWatch.start("process3");
        Thread.sleep(3000);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

}
