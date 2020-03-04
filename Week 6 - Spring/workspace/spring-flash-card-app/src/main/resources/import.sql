
INSERT INTO flash_cards (id, question, answer) VALUES (card_seq.NEXTVAL, 'What does DI promote?', 'Loose-coupling');
INSERT INTO flash_cards (id, question, answer) VALUES (card_seq.NEXTVAL, 'What is the primary IOC container in Spring?', 'ApplicationContext');
INSERT INTO flash_cards (id, question, answer) VALUES (card_seq.NEXTVAL, 'What are the Spring stereotype annotations?', '@Component, @Controller, @Service, and @Repository');
INSERT INTO flash_cards (id, question, answer) VALUES (card_seq.NEXTVAL, 'What is the minimum number of beans required to configure contextual sessions between Spring and Hibernate?', '3: data source, session factory, transaction manager');
COMMIT;

INSERT INTO app_users (id, email, username, password, role) VALUES (app_user_seq.NEXTVAL, 'wsingleton@revature.com', 'wsingleton', 'p4SSw0rd!', 'ADMIN');
INSERT INTO app_users (id, email, username, password, role) VALUES (app_user_seq.NEXTVAL, 'bkruppa@revature.com', 'bkruppa', 'p4SSw0rd!', 'DEV');
INSERT INTO app_users (id, email, username, password, role) VALUES (app_user_seq.NEXTVAL, 'kbarakat@revature.com', 'kbarakat', 'p4SSw0rd!', 'USER');
INSERT INTO app_users (id, email, username, password, role) VALUES (app_user_seq.NEXTVAL, 'troll@hotmail.com', 'troll', 'p4SSw0rd!', 'LOCKED');
COMMIT;