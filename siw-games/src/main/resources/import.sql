insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'Santa Monica', 'https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Santa_Monica_Studio.svg/1200px-Santa_Monica_Studio.svg.png');
insert into developer (id, name_company, logo) values(nextval('developer_seq'), 'SEGA', 'https://sm.ign.com/t/ign_it/screenshot/default/sega-sonic-logo_b6eu.1280.jpg');

insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'Sonic Adventure', 'Platform', '1998', 'doppiaA', '{Xbox;PC;PlayStation}','https://upload.wikimedia.org/wikipedia/en/6/60/Sonic_Adventure.PNG', '51');
insert into videogame (id, title, genre, year, budget, platforms, url_image, developer_id) values(nextval('videogame_seq'), 'God of War', 'Action', '2018', 'triplaA', '{PlayStation;PC}','https://gmedia.playstation.com/is/image/SIEPDC/god-of-war-hub-thumbnail-desktop-01-en-25jun21?$facebook$', '1');


insert into award (id, type, year) values(nextval('award_seq'), 'Platform', '1998');
insert into award (id, type, year) values(nextval('award_seq'), 'Action', '1998');

