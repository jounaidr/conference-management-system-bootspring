CREATE TABLE user_table (
user_id INT NOT NULL,
name VARCHAR(32),
username VARCHAR(32),
password VARCHAR(32),
email VARCHAR(32),
role VARCHAR(8),
confirmed BIT
PRIMARY KEY (user_id),
);


