CREATE TABLE planet(
    id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(50) NOT NULL,
    climate VARCHAR(255) NOT NULL,
    terrain VARCHAR(255),
    amount_of_movies BIGINT
) ENGINE=Innodb DEFAULT CHARSET=utf8;