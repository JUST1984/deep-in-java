package priv.just1984.deep.in.java.webflux.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-18 16:38
 */
public class FluxDemo {

    public static void main(String[] args) throws InterruptedException {
        // Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);

        Flux.range(0, 1000).subscribe(System.out::println);

        Thread.sleep(1000 * 100);
    }

}
