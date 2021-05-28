create table INSTRUMENT(
    NOM VARCHAR(50) not null primary key
);

create table MUSICIEN (
    ID                 INTEGER auto_increment primary key,
    CREATED_AT         TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    VERSION            INTEGER     not null,
    DDN                DATE,
    NOM                VARCHAR(20) not null,
    PRENOM             VARCHAR(30) not null,
    constraint UK56QLKQV990X6QLP3YO9GBACF5 unique (PRENOM, NOM)
);

create table ALBUM (
    ID                 INTEGER auto_increment primary key,
    CREATED_AT         TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    VERSION            INTEGER      not null,
    DDS                DATE,
    TITRE              VARCHAR(100) not null constraint UK_BB0N0JEPLXXLIXGEYLR29I9A8 unique,
    MUSICIEN_ID        INTEGER,
    constraint FKIQCFSK412CGOOU4TSR3BORN5M foreign key (MUSICIEN_ID) references MUSICIEN (ID)
);

create table MUSICIEN_INSTRUMENT
(
    MUSICIEN_ID   INTEGER     not null,
    INSTRUMENT_ID VARCHAR(50) not null,
    primary key (MUSICIEN_ID, INSTRUMENT_ID),
    constraint FK26GUNY6TQ8TED82MUFV42F299 foreign key (MUSICIEN_ID) references MUSICIEN (ID),
    constraint FKGYBHNW05VQT3GWMPVIDE8HNJU foreign key (INSTRUMENT_ID) references INSTRUMENT (NOM)
);