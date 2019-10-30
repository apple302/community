## 码匠社区

## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[ES社区](https://elasticsearch.cn/explore)  
[Github_Deploy_Key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)  
[Bootstrap](https://v3.bootcss.com/getting-started/)  
[Github_OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[菜鸟教程](https://www.runoob.com/)  
[Mybatis_SpringBoot](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)  
[SpringBoot官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features)  

## 工具
[Git下载](https://git-scm.com/download)  
[Visual-paradigm](https://www.visual-paradigm.com)   
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  

## 脚本
```sql
create table USER
(
	ID int auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
	primary key (ID)
);
```
```bash
mvn flyway:migrate
```