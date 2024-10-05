USE `test`;
    CREATE TABLE IF NOT EXISTS products
    (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(32) NOT NULL,
        description VARCHAR(100) NOT NULL,
        price DOUBLE NOT NULL,
        image1 BLOB(100000) NOT NULL,
        image2 BLOB(100000) NOT NULL,
        image3 BLOB(100000) NOT NULL
    );
# drop TABLE IF EXISTS products;