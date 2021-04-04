INSERT INTO AUTHORITIES (authority) VALUES ('ROLE_TEST');
INSERT INTO USERS (username, password, authority_id, enabled)
VALUES ('Username_Test', 'Password_Test', 1,true);
INSERT INTO POSTS (name, description, created, user_id)
VALUES ('Name_Test', 'Description_Test', current_timestamp, 1);