package com.gary.demo.prometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter
 * 重启后清零
 *
 * @author gary
 * @date 2019/09/03
 */
@RestController
@RequestMapping("/counter")
public class CounterController {

    private Counter counter;

    public CounterController(MeterRegistry registry) {
        // counter = registry.counter("my_counter")
        counter = Counter
                // 对应my_counter_total,如果加.baseUnit("x"),则为my_counter_x_total
                .builder("my_counter")
                .description("次数")
                .register(registry);
    }

    @RequestMapping("/increment")
    public String increment() {
        counter.increment();
        return "success";
    }

}