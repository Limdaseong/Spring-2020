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
WHERE lat between