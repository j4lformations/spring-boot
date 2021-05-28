-- insertion des données exemples dans la table MUSICIEN
insert into musicien (prenom, nom, ddn,version) values ('John', 'Mayer', '1977-10-16',0);
insert into musicien (prenom, nom, ddn,version) values ('Eric', 'Clapton', '1945-03-30',0);
insert into musicien (prenom, nom, ddn,version) values ('John', 'Butler', '1975-04-01',0);
insert into musicien (prenom, nom, ddn,version) values ('Prince', 'Nelson', '1958-06-07',0);

-- insertion des données exemples dans la table ALBUM
insert into album (MUSICIEN_ID, titre, dds,version) values (1, 'The Search For Everything', '2017-01-20',0);
insert into album (MUSICIEN_ID, titre, dds,version) values (1, 'Battle Studies', '2009-11-17',0);
insert into album (MUSICIEN_ID, titre, dds,version) values (2, 'From The Cradle', '1994-09-13',0);
insert into album (MUSICIEN_ID, titre, dds,version) values (4, 'Dirty Mind', '1980-10-08',0);

-- insertion des données exemples dans la table INSTRUMENT
insert into instrument (nom) values ('Guitare');
insert into instrument (nom) values ('Piano');
insert into instrument (nom) values ('Voix');
insert into instrument (nom) values ('Batterie');
insert into instrument (nom) values ('Synthétiseur');

-- insertion des données exemples dans la table MUSICIEN_INSTRUMENT
insert into musicien_instrument(MUSICIEN_ID, INSTRUMENT_ID) values (1, 'Guitare');
insert into musicien_instrument(MUSICIEN_ID, INSTRUMENT_ID) values (1, 'Piano');
insert into musicien_instrument(MUSICIEN_ID, INSTRUMENT_ID) values (2, 'Guitare');
insert into musicien_instrument(MUSICIEN_ID, INSTRUMENT_ID) values (4, 'Guitare');
insert into musicien_instrument(MUSICIEN_ID, INSTRUMENT_ID) values (4, 'Batterie');