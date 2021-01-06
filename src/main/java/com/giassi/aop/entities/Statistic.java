package com.giassi.aop.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

// A simple statistical data for KPI purposes
@Entity
@Table(name="statistics")
@Data
@ToString
public class Statistic {

    public Statistic() {
        creationDt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    private Long id;

    private String metricGroup;
    private String method;

    @Basic
    private LocalDateTime creationDt;

    // the elapsed time in ms
    private long elapsedTime;

}
