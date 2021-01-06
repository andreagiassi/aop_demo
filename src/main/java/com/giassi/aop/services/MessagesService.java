package com.giassi.aop.services;

import com.giassi.aop.aop.statistic.LogStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessagesService {

    @LogStatistics(metric = "ECHO")
    public String echo(String message) throws Exception {
        if (message == null) {
            throw new Exception("message cannot be null!");
        }

        return message.toUpperCase().trim();
    }
}
