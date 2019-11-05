DROP TABLE IF EXISTS `reactive-sample`.`user`;
CREATE TABLE `reactive-sample`.`user`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NULL,
    `last_name`  VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);
