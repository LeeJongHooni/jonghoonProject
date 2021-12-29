create table sign(
      id number
    , userid varchar2(30)
    , password varchar2(30)
    , email varchar2(50)
    , username varchar2(30)
    , birthday DATE
    ,signdate date
);

alter table sign add constraint pk_id primary key(id);
alter table sign modify userid constraint nn_userid not null;
alter table sign modify password constraint nn_password not null;
alter table sign modify email constraint nn_email not null;
alter table sign modify username constraint nn_username not null;
alter table sign modify birthday constraint nn_birthday not null;
alter table sign modify signdate default sysdate ;
alter table sign add profilephotopath varchar2(200);
create sequence sign_seq NOCACHE;

select * from sign;

SELECT id FROM SIGN WHERE userid = 'aaaa';

create table writer(
      wnum NUMBER
    , signid number 
    , wtitle varchar2(300)
    , wcontent varchar2(3000)
    , downloadpath varchar2(300)
    , wdate DATE
    , viewcnt number
);


alter table writer add constraint pk_wnum primary key(wnum);
alter table writer add foreign key(signid) references sign(id);
alter table writer modify wtitle constraint nn_wtitle not null;
alter table writer modify wcontent constraint nn_wcontent not null;
alter table writer modify wdate default sysdate ;
alter table writer modify viewcnt default 0;

create sequence writer_seq NOCACHE;
select * from writer where downloadpath like '%.png';
		SELECT * FROM WRITER
  		 WHERE DOWNLOADPATH LIKE '%PNG' OR DOWNLOADPATH  LIKE '%png'
                           or DOWNLOADPATH  LIKE '%JPG' OR DOWNLOADPATH  LIKE '%jpg'
                           or DOWNLOADPATH  LIKE '%JPEG' OR DOWNLOADPATH  LIKE '%jpeg'
                           or DOWNLOADPATH  LIKE '%GIF' OR DOWNLOADPATH  LIKE '%gif'; 


create table NAV_MENUS(
      ID NUMBER --식별번호   
    , NAME VARCHAR2(30) -- 메뉴명
    , URL VARCHAR2(50) -- 메뉴가 사용할 url 주소
    , ODR NUMBER  -- 메뉴순번
);

ALTER TABLE NAV_MENUS ADD CONSTRAINT PK_NAV_MENUS_ID PRIMARY KEY(ID);
ALTER TABLE NAV_MENUS MODIFY NAME CONSTRAINT NN_NAV_MENUS_NAME NOT NULL;
ALTER TABLE NAV_MENUS MODIFY URL CONSTRAINT NN_NAV_MENUS_URL NOT NULL;
ALTER TABLE NAV_MENUS MODIFY ODR CONSTRAINT NN_NAV_MENUS_ODR NOT NULL;

INSERT INTO NAV_MENUS VALUES(1, 'HOME', '/', 1);
INSERT INTO NAV_MENUS VALUES(2, '방명록', '/guest', 2);
INSERT INTO NAV_MENUS VALUES(3, '게시판', '/board', 3);

select * from nav_menus;

update nav_menus set odr = 3 where id = 2;
DELETE FROM WRITER WHERE wnum = 16;

create table usercomment(
      comment_id NUMBER REFERENCES writer(wnum)
    , userpkid NUMBER references sign(id)
    , usercomment varchar2(2000) not null
    , commentdate DATE default SYSDATE
    , good_count NUMBER default 0
    , hate_count NUMBER default 0
);
CREATE SEQUENCE COMMENT_ID_SEQ nocache;
select * from usercomment;
drop table usercomment;

select * from ALL_CONSTRAINTS where TABLE_NAME='usercomment';
