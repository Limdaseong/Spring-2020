CREATE TABLE t_user(
	i_user INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- UNSIGNED는 양수만 저장	
	user_id varchar(30) NOT NULL UNIQUE,
	user_pw varchar(70) NOT NULL,
	salt VARCHAR(30) NOT NULL,
	nm	     varchar(5) NOT NULL,
	profile_img VARCHAR(50),
	r_dt DATETIME DEFAULT NOW(),
	m_dt DATETIME DEFAULT NOW()
);

DROP TABLE c_code_m;
DROP TABLE c_code_d;
DROP TABLE t_restaurant;
DROP TABLE t_restaurant_recommend_menu;
DROP TABLE t_restaurant_menu;

CREATE TABLE t_restaurant(
	i_rest INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nm VARCHAR(20) NOT NULL,
	addr VARCHAR(100) NOT NULL,
	lat DOUBLE UNSIGNED NOT NULL,
	lng DOUBLE UNSIGNED NOT NULL,
	cd_category INT UNSIGNED NOT NULL,
	i_user INT UNSIGNED NOT NULL COMMENT '등록자',
	r_dt DATETIME DEFAULT NOW(),
	m_dt DATETIME DEFAULT NOW(),
	FOREIGN KEY (i_user) REFERENCES t_user(i_user)
);

CREATE TABLE c_code_m(
	i_m INT UNSIGNED PRIMARY KEY,
	`desc` VARCHAR(30) DEFAULT '',
	cd_nm VARCHAR(20) DEFAULT ''
);

CREATE TABLE c_code_d(
	i_m INT UNSIGNED,
	cd INT UNSIGNED,
	val VARCHAR(15) NOT NULL,
	PRIMARY KEY(i_m, cd),
	FOREIGN KEY(i_m) REFERENCES c_code_m(i_m)
);

CREATE TABLE t_restaurant_recommend_menu (
	i_rest INT UNSIGNED,
	seq INT UNSIGNED,
	menu_nm VARCHAR(20) NOT NULL,
	menu_price INT UNSIGNED NOT NULL,
	menu_pic VARCHAR(50),
	PRIMARY KEY(i_rest, seq),
	FOREIGN KEY(i_rest) REFERENCES t_restaurant(i_rest)
);

CREATE TABLE t_restaurant_menu (
	i_rest INT UNSIGNED,
	seq INT UNSIGNED,
	menu_pic VARCHAR(50),
	PRIMARY KEY(i_rest, seq),
	FOREIGN KEY(i_rest) REFERENCES t_restaurant(i_rest)
);

