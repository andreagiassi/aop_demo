package com.giassi.aop.rest;

import com.giassi.aop.aop.statistic.LogStatistics;
import com.giassi.aop.services.MathService;
import com.giassi.aop.services.MessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** NOTE: these endpoints are just an example where to apply the @LogStatistics annotation */
@RestController
@Slf4j
public class AOPDemoRestController {

    @Autowired
    private MathService mathService;

    @Autowired
    private MessagesService messagesService;


    //  return the sum of the two numbers given
    @LogStatistics(metric = "REST_MATH")
    @CrossOrigin(origins = "*")
    @PostMapping("/api/numbers")
    public long sum(@RequestParam(value = "a") long a, @RequestParam(value = "b") long b) {
        try {
            return mathService.sum(a, b);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return 0;
        }
    }

    // Echo a forwarded message in upper case
    @CrossOrigin(origins = "*")
    @PostMapping("/api/messages")
    public String echo(@RequestParam(value = "message") String message) {
        try {
            return messagesService.echo(message);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

}