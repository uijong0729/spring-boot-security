-- 초기데이터 작성
insert into issues (summary, description) values ('バグA', 'バグがあります');
insert into issues (summary, description) values ('機能要望B', 'Bに追加機能がほしいです');
insert into issues (summary, description) values ('画面Cが遅い', '早くしてほしいです');

-- pw : 123412341234
insert into users (username, password, authority) values ('myuser', 'b5e27f42ec1693db70cd788b8e39921a553d3aecff89b624196ccab2790598725e9b4b90feac479e', 'ADMIN');
insert into users (username, password, authority) values ('user', 'b5e27f42ec1693db70cd788b8e39921a553d3aecff89b624196ccab2790598725e9b4b90feac479e', 'USER');