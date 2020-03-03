##github 
access_token：
https://api.github.com/user?access_token=1a2e0cd19e415d1df5b54760354c1640788b131c
##springboot-mybatis
https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
##springboot官方文档
https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/
##mysql数据库设计
question表：
```mysql
create table question
(
	id int auto_increment
		primary key,
	title char null,
	description varchar(50) null,
	gmt_create bigint null,
	gmt_modified bigint null,
	creator int null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(256) null
);
```
user表：
```mysql
create table user
(
	id int auto_increment
		primary key,
	account_id varchar(100) null,
	name varchar(50) null,
	token char(36) null,
	gmt_create bigint null,
	gmt_modified bigint null,
	avatar_url text null,
    bio varchar(256) null
);


```
##mybatis-generator

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate