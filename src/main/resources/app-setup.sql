USE grocery_db;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS grocery;


CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(240) NOT NULL,
    email VARCHAR(240) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    role VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
    
);

CREATE TABLE grocery (
	id BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT,
    display_id VARCHAR(240) UNIQUE NOT NULL,
    description VARCHAR(240) NOT NULL,
    last_sold DATE,
    shelf_life VARCHAR(240) NOT NULL,
    department VARCHAR(240) NOT NULL,
    price decimal(15,2),
    unit VARCHAR(240) NOT NULL,
    x_for INT UNSIGNED NOT NULL,
    cost decimal(15,2),
    PRIMARY KEY (id)
    -- 124872,Lettuce,9/11/2017,5d,Produce, 0.79 ,'lb',1, 0.10
);

INSERT INTO users
(name, email, password, enabled)
VALUES
('Jeremy', 'jeremy@heb.com', 'password', true);

INSERT INTO user_roles
(role, email)
VALUES
('ROLE_USER', 'jeremy@heb.com');

INSERT INTO grocery
(display_id,description,last_sold,shelf_life,department, price ,unit,x_for, cost)
VALUES
('753542','banana','2017-09-05','4d','Produce', 2.99 ,'lb',1, 0.44),
('321654','apples','2017-09-06','7d','Produce', 1.49 ,'lb',1, 0.20),
('95175','Strawberry','2017-09-07','3d','Produce', 2.49 ,'lb',1, 0.10),
('321753','onion','2017-09-08','9d','Produce', 1.00 ,'Each',1, 0.05),
('987654','Tomato','2017-09-09','4d','Produce', 2.35 ,'lb',1, 0.20),
('11122','grapes','2017-09-10','7d','Produce', 4.00 ,'lb',1, 1.20),
('124872','Lettuce','2017-09-11','5d','Produce', 0.79 ,'lb',1, 0.10),
('113','bread','2017-09-12','14d','Grocery', 1.50 ,'Each',1, 0.12),
('1189','hamburger buns','2017-09-13','14d','Grocery', 1.75 ,'Each',1, 0.14),
('12221','pasta sauce','2017-09-14','23d','Grocery', 3.75 ,'Each',1, 1.00),
('1111','cheese slices','2017-09-15','20d','Grocery', 2.68 ,'Each',1, 0.40),
('18939','sliced turkey','2017-09-16','20d','Grocery', 3.29 ,'Each',1, 0.67),
('90879','tortilla chips','2017-09-17','45d','Grocery', 1.99 ,'Each',1, 0.14),
('119290','cereal','2017-09-18','40d','Grocery', 3.19 ,'Each',1, 0.19),
('4629464','canned vegtables','2017-09-19','200d','Grocery', 1.89 ,'Each',1, 0.19),
('9000001','headache medicine','2017-09-20','365d','Pharmacy', 4.89 ,'Each',1, 1.90),
('9000002','Migraine Medicine','2017-09-21','365d','Pharmacy', 5.89 ,'Each',1, 1.90),
('9000003','Cold and Flu','2017-09-22','365d','Pharmacy', 3.29 ,'Each',1, 1.90),
('9000004','Allegry Medicine','2017-09-23','365d','Pharmacy', 3.00 ,'Each',1, 1.25),
('9000005','Pain','2017-09-24','365d','Pharmacy', 2.89 ,'Each',1, 1.00)
/**
CREATE TABLE images (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    path VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE posts (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT,
    image_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    FOREIGN KEY (image_id) REFERENCES images(id)
        ON DELETE CASCADE
);

CREATE TABLE tags (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(240) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post_tag (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    post_id INT UNSIGNED NOT NUlL,
	tag_id INT UNSIGNED NOT NUlL,
	PRIMARY KEY(id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
        ON DELETE CASCADE,
	FOREIGN KEY (tag_id) REFERENCES tags(id)
        ON DELETE CASCADE
);

CREATE TABLE votes (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    post_id INT UNSIGNED NOT NUlL,
    user_id INT UNSIGNED NOT NULL,
    vote INT SIGNED NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
        ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
**/
