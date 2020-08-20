CREATE TABLE IF NOT EXISTS `service`
(
    `id`              BIGINT(20)  NOT NULL COMMENT '' Primary key '',
    `name`            VARCHAR(45) NULL COMMENT '' Service name '',
    `fixed_attribute` VARCHAR(45) NULL COMMENT '' Service’s fixed attribute '',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `customer`
(
    `id`           BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
    `name`         VARCHAR(45) NULL COMMENT 'Customer name',
    `login_name`   VARCHAR(45) NOT NULL,
    `login_secret` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `customer_service_subscription`
(
    `id`                            BIGINT(20)  NOT NULL COMMENT 'Primary key',
    `customer_id`                   BIGINT(20)  NOT NULL COMMENT 'Customer id',
    `service_id`                    BIGINT(20)  NOT NULL COMMENT 'Customer subscribed service id',
    `customer_changeable_attribute` VARCHAR(45) NULL COMMENT 'Change this value when customer
modify subscribed service',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;