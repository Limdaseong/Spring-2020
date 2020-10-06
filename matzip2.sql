SELECT
A.nm, A.addr, A.i_user, A.hits AS cntHits
, B.val AS cd_category_nm
, IFNULL(C.cnt, 0) AS cntFavorite
FROM t_restaurant A
LEFT JOIN c_code_d B
ON A.cd_category = B.cd
AND B.i_m = 1
LEFT JOIN (
	SELECT i_rest ,COUNT(i_rest) AS cnt 
	FROM t_user_favorite
	WHERE i_rest = 1
	GROUP BY i_rest
) C
ON A.i_rest = C.i_rest
WHERE A.i_rest = 1;	

SELECT * FROM t_restaurant_recommend_menu;



DELETE FROM t_restaurant_recommend_t_restaurantmenu;

CREATE TABLE t_user_favorite(
	i_rest INT UNSIGNED,
	i_user INT UNSIGNED,
	r_dt DATETIME DEFAULT NOW(),
	PRIMARY KEY(i_rest, i_user),
	FOREIGN KEY(i_rest) REFERENCES t_restaurant(i_rest),
	FOREIGN KEY(i_user) REFERENCES t_user(i_user)	
);

DELETE A  -- A만 지울거니까 A만 적었음
FROM t_restaurant_recommend_menu A
INNER JOIN t_restaurant B
ON A.i_rest = B.i_rest
AND B.i_user = 1
WHERE A.i_rest = 3
AND A.seq = 2;

DELETE FROM t_restaurant_recommend_menu
WHERE menu_pic IS null;
AND A.seq = 2
AND B.i_user = 4;

COMMIT;


DELETE FROM t_restaurant;
DELETE FROM t_restaurant_menu;
DELETE FROM t_restaurant_recommend_menu;
DELETE FROM t_user;

SELECT * FROM t_user;

SELECT i_user, user_id, user_pw, salt, nm, profile_img, r_dt
		FROM t_user
		WHERE  user_id = 'ddd';
		
		
SELECT i_rest, nm, lat, lng
FROM t_restaurant
WHERE lat BETWEEN;

SELECT 
			A.i_rest, A.nm, A.lat, A.lng, A.addr, A.i_user, A.hits
			, ifnull(B.val, '') as cd_category_nm
			, C.nm as user_nm
			, ifnull(D.cnt, 0) as cnt_favorite
		FROM t_restaurant A
		LEFT join c_code_d B
			ON A.cd_category = B.cd
			AND i_m = 1 
		LEFT JOIN t_user C
			ON A.i_user = C.i_user
		LEFT JOIN (
			SELECT i_rest, COUNT(i_rest) as cnt
			FROM t_user_favorite
			WHERE i_rest = 7
			GROUP BY i_rest
		) D
		ON A.i_rest = D.i_rest
		WHERE A.i_rest = 7;
		
SELECT * FROM t_restaurant;

DELETE FROM t_restaurant
WHERE i_user = 5 AND i_rest = 11;

DELETE B, C, D FROM t_restaurant A
LEFT JOIN t_restaurant_recommend_menu B
ON A.i_rest = B.i_rest
LEFT JOIN t_restaurant_menu C
ON A.i_rest = C.i_rest
LEFT JOIN t_user_favorite D
ON A.i_rest = D.i_rest
WHERE A.i_rest = 7
AND A.i_user = 5;


AND B.i_user = 5
WHERE A.i_rest = 1;


DELETE FROM t_restaurant_recommend_menu
WHERE i_rest = 1;

INSERT INTO t_restaurant_menu
(seq, menu_pic)
VALUES 
(IFNULL(MAX(seq), 0)+1, 'asdf')
WHERE i_rest = 16;

DELETE FROM t_restaurant_recommend_menu
WHERE i_rest = 12;

DELETE FROM t_restaurant_menu;

UPDATE t_restaurant
SET hits = hits + 1
WHERE i_rest = 12
AND i_user != 12;



SELECT 
		A.i_rest, A.nm, A.lat, A.lng, A.addr, A.i_user, A.hits
		, ifnull(B.val, '') as cd_category_nm
		, C.nm as user_nm
		, ifnull(D.cnt, 0) as cnt_favorite
		, case when E.i_rest IS NULL then 0 ELSE END AS isFavorite
	FROM t_restaurant A
	LEFT JOIN c_code_d B
		ON A.cd_category = B.cd
		AND i_m = 1 
	LEFT JOIN t_user C
		ON A.i_user = C.i_user
	LEFT JOIN (
		SELECT i_rest, COUNT(i_rest) as cnt
		FROM t_user_favorite
		WHERE i_rest = #{i_rest}
		GROUP BY i_rest
	) D
	ON A.i_rest = D.i_rest
	LEFT JOIN t_user_favorite E
	ON A.i_rest = E.i_rest
	AND E.i_user = 4
	WHERE A.i_rest = 6;
	WHERE A.i_rest = #{i_rest};
	;
	
	
CREATE TABLE t_user(
		i_user INT PRIMARY KEY AUTO_INCREMENT,
		uid VARCHAR(30) NOT NULL,
		upw VARCHAR(80) NOT NULL,
		nm VARCHAR(10),
		r_datetime DATETIME DEFAULT NOW()
	);
	
SELECT 
	i_rest, i_user, r_dt
FROM t_user_favorite 
WHERE i_user = 7;

	
SELECT 
	A.i_rest, A.i_user, A.r_dt, B.menu_pic AS main_pic
FROM t_user_favorite A
LEFT JOIN (
	SELECT *
	FROM t_restaurant_recommend_menu A
	INNER JOIN (
		SELECT i_rest, MIN(seq) AS seq
		FROM t_restaurant_recommend_menu
		GROUP BY i_rest
	) B
	ON A.i_rest = B.i_rest
	AND A.seq = B.seq
) B
ON A.i_rest = B.i_rest
WHERE A.i_user =;

SELECT *
FROM t_restaurant_recommend_menu A
INNER JOIN (
	SELECT i_rest, MIN(seq) AS seq
	FROM t_restaurant_recommend_menu
	GROUP BY i_rest
) B
ON A.i_rest = B.i_rest
AND A.seq = B.seq;
	
SELECT i_rest, MIN(seq) AS seq
FROM t_restaurant_recommend_menu
GROUP BY i_rest;

SELECT 
	A.i_rest, A.i_user, A.r_dt
	, B.nm AS rest_nm, B.addr AS rest_addr
FROM t_user_favorite A
INNER JOIN t_restaurant B
ON A.i_rest = B.i_rest
WHERE A.i_user = ;