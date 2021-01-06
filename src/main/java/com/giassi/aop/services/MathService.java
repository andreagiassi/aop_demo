package com.giassi.aop.services;

import com.giassi.aop.aop.statistic.LogStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MathService {

    @LogStatistics(metric = "MATH")
    public long sum(final long a, final long b) {
        log.info("Performing the sum of " + a + " and " + b);
        return a + b;
    }

}
