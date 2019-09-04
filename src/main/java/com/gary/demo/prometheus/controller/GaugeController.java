package com.gary.demo.prometheus.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * A gauge is a handle to get the current value
 * Typical examples for gauges would be the size of a collection or map or number of threads in a running state.
 *
 * @author gary
 * @date 2019/09/03
 */
@RestController
@RequestMapping("/gauge")
public class GaugeController {

    private final Queue<Long> queue = new LinkedBlockingDeque<>(100);

    public GaugeController(MeterRegistry registry) {
        // registry.gaugeMapSize
        registry.gaugeCollectionSize("my_queue_size", Tags.empty(), this.queue);
    }

    @RequestMapping("/offer")
    public String offer() {
        queue.offer(System.currentTimeMillis());
        return "success";
    }

    @RequestMapping("/poll")
    public String poll() {
        return String.valueOf(queue.poll());
    }

}