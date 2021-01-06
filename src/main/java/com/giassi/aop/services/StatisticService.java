package com.giassi.aop.services;

import com.giassi.aop.entities.Statistic;
import com.giassi.aop.repositories.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Async
    @Transactional
    public void statData(Statistic stat) {
        statisticRepository.save(stat);
    }

    @Async
    @Transactional
    public void statData(String method, final long elapsedTime) {
        // TODO: check if statistics are enabled

        // create statistic data
        Statistic stat = new Statistic();
        stat.setMethod(method);
        stat.setElapsedTime(elapsedTime);

        statisticRepository.save(stat);
    }

}
