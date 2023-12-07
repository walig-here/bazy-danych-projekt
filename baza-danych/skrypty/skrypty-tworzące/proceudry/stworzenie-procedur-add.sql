-- add_new_locality
DELIMITER //
CREATE OR REPLACE PROCEDURE add_new_locality (
	IN locality_name VARCHAR(30),
	IN locality_desc VARCHAR(1000),
	IN pop INT(10),
	IN municipality_id INT(10),
	IN latitude REAL,
	IN longitude REAL
) BEGIN
	-- uzupełnić
END;
// 
DELIMITER ;

-- add_new_attraction
DELIMITER //
CREATE OR REPLACE PROCEDURE add_new_attraction (
	IN attraction_name VARCHAR(30),
	IN attraction_desc VARCHAR(1000),
	IN locality_id INT(10),
	IN street VARCHAR(50),
	IN buildig_number VARCHAR(30),
	IN flat_number VARCHAR(30)
) BEGIN
	-- uzupełnić
END;
// 
DELIMITER ;

-- add_locality_to_fav_list
DELIMITER //
CREATE OR REPLACE PROCEDURE add_locality_to_fav_list (
	IN locality_id INT(10),
	IN adnotation VARCHAR(1000)
) BEGIN
	-- uzupełnić
END;
// 
DELIMITER ;

-- register_user
DELIMITER //
CREATE OR REPLACE PROCEDURE register_user (
	IN	user_login  VARCHAR(30),
	IN user_password VARCHAR(48)
) BEGIN
	
	-- Pierwsze konto w systemie otrzymuje role administratora merytorycznego
	DECLARE user_amount INT;
	DECLARE user_role VARCHAR(30);
	SELECT COUNT(*) INTO user_amount FROM users;
	
	-- Dodanie nowego konta do serwera bazodanowego
	set @sql = concat("CREATE USER '",`user_login`,"'@'%","' IDENTIFIED BY '",`user_password`,"'");
   PREPARE stmt1 FROM @sql;
   EXECUTE stmt1;
   DEALLOCATE PREPARE stmt1;

	-- Ustalenie roli użytkownika
	IF user_amount = 0 THEN
		SET user_role = 'technical_administrator';
	ELSE
		SET user_role = 'viewer';
	END IF;
	
	set @sql = concat("GRANT ",`user_role`," TO ",`user_login`);
   PREPARE stmt2 FROM @sql;
   EXECUTE stmt2;
   DEALLOCATE PREPARE stmt2;
   FLUSH PRIVILEGES;
   
   set @sql = concat("SET DEFAULT ROLE ",`user_role`," FOR ",`user_login`);
   PREPARE stmt2 FROM @sql;
   EXECUTE stmt2;
   DEALLOCATE PREPARE stmt2;
   FLUSH PRIVILEGES;
	
	-- Dodanie nowego konta do bazy danych
	INSERT INTO users (users.login,users.`password`,users.role) VALUES (user_login, user_password, user_role);
END;
// 
DELIMITER ;