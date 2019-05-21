create database news_database;
ALTER DATABASE news_database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use news_database;
-- drop database news_database;

create table priority(
priority_id int primary key
);

create table app_user(
user_id int auto_increment primary key,
role_id int not null,
username varchar(20) unique not null,
created_date datetime default current_timestamp,
user_password text not null,
fullname nvarchar(50) default 'Người dùng mới',
edit_time datetime default current_timestamp
);

create table app_role(
role_id int auto_increment primary key,
role_name nvarchar(10) unique not null
);

create table tag(
tag_id int auto_increment primary key,
tag_name nvarchar(20) not null unique
);

create table news(
news_id varchar(14) primary key default '20190101115530',
summary text not null,
thumpnail varchar(200) not null default 'http://localhost:8080/img/default-thumpnail.jpg',
content text not null,
author_id int not null,
acceptance_user_id int not null,
priority_id int not null default 0
);

create table tag_news(
tag_id int not null,
news_id varchar(14) not null,
primary key (tag_id, news_id)
);

-- FOREIGN KEY
alter table app_user add constraint FK_RoleUser foreign key(role_id) references app_role(role_id);

alter table news add constraint FK_AuthorNews foreign key(author_id) references app_user(user_id);
alter table news add constraint FK_AcceptanceUserNews foreign key(acceptance_user_id) references app_user(user_id);

alter table tag_news add constraint FK_TagTagNews foreign key(tag_id) references tag(tag_id);
alter table tag_news add constraint FK_NewsTagNews foreign key(news_id) references news(news_id);