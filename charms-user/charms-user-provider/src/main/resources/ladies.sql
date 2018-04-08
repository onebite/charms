create table lady_stories
(
   story_id  bigint auto_increment comment '故事ID' primary key,
   lady_no varchar(64) not null comment '淑女编号',
   title varchar(120) not null comment '故事标题',
   key_words varchar(1000) DEFAULT '' comment '故事关键字 逗号隔开',
   summary varchar(1000)  DEFAULT  '' comment '故事摘要',
   dialog  blod comment '故事原文本',
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间',
   update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP comment '更新时间',
   remove_status tinyint(2) default '0' comment '删除状态 1删除',
   constraint only unique(lady_no)
)
comment '淑女故事（分享）'
;

create table lady_main
(
  lady_no varchar(64) primary key comment '淑女编号',
  real_name varchar(30) DEFAULT '' comment '真实姓名',
  nick_nae varchar(100) DEFAULT '' comment '昵称',
  birth_date varchar(8) DEFAULT '18990101' comment '生日 字符串 默认18990101 年份默认1900',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP comment '更新时间',
  remove_status remove_status tinyint(2) default '0'  comment '删除状态 1删除',
)
comment '淑女主体';


create table lady_property_group
(
  group_code varchar(10) PRIMARY KEY comment '属性组编码',
  group_name varchar(32) not null comment '属性名称'
)
comment '淑女特征属性组（字典表）';

insert into lady_property_group VALUES ('lpg001','颜值');
insert into lady_property_group VALUES ('lpg002','性格');
insert into lady_property_group VALUES ('lpg003','素养');
insert into lady_property_group VALUES ('lpg004','爱心');
insert into lady_property_group VALUES ('lpg005','社交');
insert into lady_property_group VALUES ('lpg006','心理');
insert into lady_property_group VALUES ('lpg007','才华');

create table lady_property
(
  property_no varchar(32) primary key comment '属性编码',
  property_name varchar(64) not null comment '属性名称',
)
comment '淑女特征';

