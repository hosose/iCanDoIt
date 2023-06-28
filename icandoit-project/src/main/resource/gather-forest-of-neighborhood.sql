SELECT * FROM V$SESSION WHERE OSUSER != 'SYSTEM';
select * from post where GATHERING_TYPE='모집마감' ;

CREATE TABLE MEMBER (
	USER_ID	 VARCHAR2(20) PRIMARY KEY,
	PASSWORD	VARCHAR2(30)		NOT NULL,
	ADDRESS	VARCHAR2(100)		NOT NULL,
	PHONE	VARCHAR2(50)		NOT NULL,
	NICK_NAME	VARCHAR2(100)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL
);
-- ALTER TABLE [테이블명] MODIFY ([컬럼명] VARCHAR2(2000));
ALTER TABLE member MODIFY (ADDRESS VARCHAR2(500));
INSERT INTO MEMBER
	VALUES ('java',	'a',
	'성남시 분당구'	,	'010-1111-1212',	'자바킹',	'아이유');
SELECT *FROM MEMBER
CREATE TABLE POST(
	POST_NO	NUMBER		PRIMARY KEY,
	TITLE	VARCHAR2(200)		NOT NULL,
	POST_CONTENT	CLOB		NOT NULL,
	IMG	VARCHAR2(100)		NOT NULL,
	CATEGORY_TYPE	VARCHAR2(100)		NOT NULL,
	TIME_POSTED	DATE		NOT NULL,
	GATHERING_TYPE 	VARCHAR2(20)		NOT NULL,
	GATHERING_PERIOD	DATE		NOT NULL,
	CURRENT_COUNT 	NUMBER		NOT NULL,
	MAX_COUNT 	NUMBER		NOT NULL,
	USER_ID 	VARCHAR2(20)		NOT NULL,
	CONSTRAINT post_user_id_fk FOREIGN KEY(USER_ID) 
	REFERENCES MEMBER(USER_ID) ON DELETE CASCADE
);

ALTER TABLE post DROP COLUMN CURRENT_COUNT;

create sequence post_seq;
ALTER TABLE post MODIFY current_count NUMBER DEFAULT 1 ;

--DEFAULT 용 (비지니스적으로 커질 가능성 농후)
INSERT INTO POST(POST_NO,	TITLE	,	POST_CONTENT	,	IMG	,
	CATEGORY_TYPE,	TIME_POSTED	,	GATHERING_TYPE 	,
	GATHERING_PERIOD,	MAX_COUNT ,	USER_ID )
	VALUES (post_seq.nextval,	'당구모임',	'이번주 금요일에 만나요~',	'당구.jpg'	,	'운동'	,
	sysdate,	'모집중' 	,	'2023-06-23'	, 	4 	,	'java' );
--DEFAULT X	
INSERT INTO POST
	VALUES (post_seq.nextval,	'당구모임',	'이번주 금요일에 만나요~',	'당구.jpg'	,	'운동'	,
	sysdate,	'모집중' 	,	'2023-06-23'	, 2, 	4 	,	'java' );

<<<<<<< HEAD
	SELECT  p.post_no, p.title	, p.post_content	, p.img	,  p.gathering_type, TO_CHAR(gathering_period,'YYYY-MM-DD') gathering_period,  p.max_count, (SELECT count(*) FROM join_club WHERE post_no = ?) current_count,
	j.user_id
	FROM post p	 
	WHERE p.post_no=1
	
=======
	SELECT * FROM post
>>>>>>> refs/heads/main
	
CREATE TABLE POST_COMMENT (
	COMMENT_NO	NUMBER		PRIMARY KEY,
	COMMENT_CONTENT	VARCHAR2(1000)		NOT NULL,
	POST_NO	NUMBER		NOT NULL,
	USER_ID	 VARCHAR2(20)		NOT NULL,
	CONSTRAINT comment_user_id_fk FOREIGN KEY(USER_ID) 
	REFERENCES MEMBER(USER_ID) ON DELETE CASCADE,
	CONSTRAINT comment_post_no_fk FOREIGN KEY(post_no) 
	REFERENCES post(post_no) ON DELETE CASCADE
);

create sequence comment_seq;

INSERT INTO post_comment
	VALUES (comment_seq.nextval,	'저는 4구 100쳐요.',	1,	'java' );

	SELECT * FROM post_comment

CREATE TABLE POST_LIKE (
	LIKE_NO 	NUMBER		PRIMARY KEY,
	POST_NO	NUMBER		NOT NULL,
	USER_ID 	VARCHAR2(20)		NOT NULL,
	CONSTRAINT like_user_id_fk FOREIGN KEY(USER_ID) 
	REFERENCES MEMBER(USER_ID) ON DELETE CASCADE,
	CONSTRAINT like_post_no_fk FOREIGN KEY(post_no) 
	REFERENCES post(post_no) ON DELETE CASCADE
);

create sequence like_seq;

INSERT INTO POST_LIKE
	VALUES (like_seq.nextval,	1,	'java' );

	SELECT * FROM POST_LIKE

CREATE TABLE JOIN_CLUB (
	JOIN_CLUB_NO 	NUMBER		PRIMARY KEY,
	POST_NO	NUMBER		NOT NULL,
	USER_ID 	VARCHAR2(20)		NOT NULL,
	CONSTRAINT join_club_user_id_fk FOREIGN KEY(USER_ID) 
	REFERENCES MEMBER(USER_ID) ON DELETE CASCADE,
	CONSTRAINT join_club_post_no_fk FOREIGN KEY(post_no) 
	REFERENCES post(post_no) ON DELETE CASCADE
);
create sequence join_club_seq;

	SELECT m.nick_name FROM join_club j
	LEFT JOIN member m ON j.user_id = m.user_id
	WHERE post_no=1
	
	SELECT * FROM post

	UPDATE post SET current_count = 1
	WHERE post_no = 1;

	INSERT INTO join_club
	VALUES (join_club_seq.nextval,	1,	'java' );

	DELETE join_club






