CREATE TABLE MEMBER (
	USER_ID	 VARCHAR2(20) PRIMARY KEY,
	PASSWORD	VARCHAR2(30)		NOT NULL,
	ADDRESS	VARCHAR2(100)		NOT NULL,
	PHONE	VARCHAR2(50)		NOT NULL,
	NICK_NAME	VARCHAR2(100)		NOT NULL,
	NAME	VARCHAR2(30)		NOT NULL
);
-- ALTER TABLE [테이블명] MODIFY ([컬럼명] VARCHAR2(2000));

select count(*) from member where NICK_NAME = '자바킹';
select count(*) from member where user_id= 'mtest';
ALTER TABLE member MODIFY (ADDRESS VARCHAR2(500));
INSERT INTO MEMBER
	VALUES ('java',	'a',
	'성남시 분당구'	,	'010-1111-1212',	'자바킹',	'아이유');
select USER_ID, password, address, NICK_NAME from member where USER_ID = 'mtest' and password = 'a';
select USER_ID from member where USER_ID = 'mtest';
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

	SELECT  post_no, title	, post_content	, img	,  gathering_type, gathering_period,
	  max_count, user_id  FROM post 
	  JOIN
	  WHERE post_no=1
-- delete from post_comment where COMMENT_CONTENT like '%댓글%';
-- DELETE FROM POST_COMMENT WHERE COMMENT_NO = 51;
	  
	 SELECT * FROM POST_COMMENT
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
	VALUES (comment_seq.nextval, '저는 4구 100쳐요.', 1,	'java' );

	SELECT * FROM post_comment
select comment_no, nick_name, pc.comment_content, m.user_id 
from member m inner join post_comment pc on m.user_id = pc.user_id inner join post p on pc.post_no=p.post_no 
where p.post_no =	1
order by comment_no desc;
	
DELETE FROM POST_COMMENT WHERE COMMENT_NO =
select row_number() over(ORDER BY comment_no DESC) as comment_no, nick_name, p.post_no, pc.comment_content, m.user_id
from member m inner join post_comment pc on m.user_id = pc.user_id inner join post p on pc.post_no=p.post_no
where p.post_no =1;

select row_number() over(ORDER BY comment_no DESC) as comment_no, nick_name, pc.comment_content 
from member m inner join post_comment pc on m.user_id = pc.user_id inner join post p on pc.post_no=p.post_no  where p.post_no =1;

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

	SELECT * FROM join_club
	SELECT * FROM post

	UPDATE post SET current_count = 1
	WHERE post_no = 1;

	INSERT INTO join_club
	VALUES (join_club_seq.nextval,	1,	'java' );

	DELETE join_club

select user_id, from
where user_id = 'mtest';

-- 댓글 리스트 참고 사항
-- SELECT 한 데이터를 다시 INSERT하는 구문 : 4번 실행 -> 48개 게시물을 INSERT 하게 된다 
INSERT INTO board(no,title,content,time_posted,id)
SELECT board_seq.nextval,title,content,sysdate,id FROM board 

-- 게시판 Pagination SQL 
-- step1 :  게시물 리스트 화면에서 사용하는 sql 에  row_number() over() 함수를 적용  
SELECT row_number() over(ORDER BY no DESC) as rnum, no, title, time_posted, hits FROM board 

-- step2 : 게시물 리스트 1page에 해당하는 게시물 리스트를 조회 ( rnum 1 이상  5 이하 )
--        : 한페이지에 5개씩 보여줄 예정 
--        : inline view 를 이용 ( from 절에 사용하는 subquery 를 말함 ) 
SELECT rnum, no, title, to_char(time_posted, 'yyy-mm-dd') as time_posted, hits, id
from(
	select row_number() over(ORDER BY no DESC) as rnum, no, title, time_posted, hits, id FROM board 
)b where rnum between 1 and 5;

-- step 3 :  step2 조회 결과에 더해서 게시물 리스트에는 회원명 즉 작성자명이 필요하다 
--			   join 을 이용해 id가 일치하는 회원의 회원 name 을 함께 조회되도록 한다 
SELECT rnum, b.no, b.title, to_char(time_posted, 'yyy-mm-dd') as time_posted, b.hits, m.name
from(
	select row_number() over(ORDER BY no DESC) as rnum, no, title, time_posted, hits, id FROM board 
)b inner join community_member m on b.id = m.id
where rnum between 1 and 5;


