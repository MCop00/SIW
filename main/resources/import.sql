insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'Santa Monica', 'https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Santa_Monica_Studio.svg/1200px-Santa_Monica_Studio.svg.png');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'SEGA', 'https://sm.ign.com/t/ign_it/screenshot/default/sega-sonic-logo_b6eu.1280.jpg');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'CD Projekt', '/images/CDProjekt.png');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'Ubisoft', '/images/Ubisoft.png');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'Activision', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Activision.svg/1280px-Activision.svg.png');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'From Software', 'https://download.logo.wine/logo/FromSoftware/FromSoftware-Logo.wine.png');


insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'Sonic Adventure', 'Platform', '1998', 'triplaA', '{Xbox;PC;PlayStation}','https://upload.wikimedia.org/wikipedia/en/6/60/Sonic_Adventure.PNG', '51');
insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'God of War', 'Action', '2018', 'triplaA', '{PlayStation;PC}','https://gmedia.playstation.com/is/image/SIEPDC/god-of-war-hub-thumbnail-desktop-01-en-25jun21?$facebook$', '1');
insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'Far Cry 3', 'Shooter', '2012', 'triplaA', '{Xbox;PC;PlayStation}','https://gaming-cdn.com/images/products/96/orig-fallback-v1/far-cry-3-pc-gioco-ubisoft-connect-europe-cover.jpg?v=1701181729', '151');
insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'Prince Of Persia', 'Adventure', '2010', 'triplaA', '{Xbox;PC;PlayStation}','https://sm.ign.com/t/ign_it/screenshot/default/prince-of-persia-le-sabbie-del-tempo-02_npe4.1280.jpg', '151');
insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'Sekiro', 'Action', '2019', 'triplaA', '{Xbox;PC;PlayStation}','https://upload.wikimedia.org/wikipedia/en/6/60/Sonic_Adventure.PNG', '51');


insert into award (id, type, year) values(nextval('award_seq'), 'Platform', '1998');
insert into award (id, type, year) values(nextval('award_seq'), 'Action', '2018');
insert into award (id, type, year) values(nextval('award_seq'), 'Action', '2019');
insert into award (id, type, year) values(nextval('award_seq'), 'Adventure', '2010');
