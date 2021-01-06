
DROP TABLE IF EXISTS statistics;

CREATE TABLE statistics (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    creation_dt timestamp NOT NULL DEFAULT current_timestamp,
    metric_group varchar(60) COMMENT 'Metric group',
    method varchar(400) NOT NULL COMMENT 'Method called',
    elapsed_time bigint(20) NOT NULL DEFAULT 0 COMMENT 'Elapsed execution time',
    PRIMARY KEY (id)
);
