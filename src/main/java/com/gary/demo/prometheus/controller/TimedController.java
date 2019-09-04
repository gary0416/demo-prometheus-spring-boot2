package com.gary.demo.prometheus.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Prometheus Timer produces two counter time series with different names:
 * ${name}_count - Total number of all calls.
 * ${name}_sum - Total time of all calls.
 *
 * @author gary
 * @date 2019/09/03
 */
@Timed
@RestController
public class TimedController {

    @Timed(value = "my_timed_method")
    @GetMapping("/myTimedMethod")
    public String myTimedMethod() {
        return String.valueOf(System.currentTimeMillis());
    }

}
