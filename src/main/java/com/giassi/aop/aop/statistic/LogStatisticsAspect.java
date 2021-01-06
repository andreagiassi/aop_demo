package com.giassi.aop.aop.statistic;

import com.giassi.aop.entities.Statistic;
import com.giassi.aop.services.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogStatisticsAspect {

    @Autowired
    private StatisticService statisticService;

    @Around("@annotation(logStatistics)")
    public Object logStatistics(final ProceedingJoinPoint joinPoint, LogStatistics logStatistics) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        // track the marked method
        Statistic statisticData = new Statistic();

        // set the metric group, if exists
        String metric = logStatistics.metric();
        if (!Strings.isEmpty(metric)) {
            statisticData.setMetricGroup(metric);
        }

        statisticData.setMethod(joinPoint.getSignature().getName());
        statisticData.setElapsedTime(elapsedTime);
        statisticService.statData(statisticData);

        return proceed;
    }

}