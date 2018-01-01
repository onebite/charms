create table user_auth
(
	id bigint auto_increment
		primary key,
	uid bigint default '0' not null comment '用户id',
	identity_type tinyint default '1' not null comment '1 手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博',
	identifier varchar(50) default '' not null comment '手机号 邮箱 用户名或第三方应用的唯一标识',
	certificate varchar(20) default '' not null comment '密码凭证(站内的保存密码，站外的不保存或保存token)',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '绑定时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '更新绑定时间',
	remove_status tinyint(2) default '0' null comment '删除状态',
	constraint only
		unique (uid, identity_type)
)
comment '用户授权表'
;

create index idx_uid
	on user_auth (uid)
;

create table user_base
(
	uid bigint not null comment '用户ID'
		primary key,
	user_role int(10) unsigned default '2000' not null comment '2000 运营',
	register_source tinyint default '0' not null comment '注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博',
	user_name varchar(32) default '' not null comment '用户账号，必须唯一',
	nick_name varchar(32) default '' not null comment '用户昵称',
	gender tinyint(1) unsigned default '0' not null comment '用户性别 0-female 1-male',
	birthday bigint default '0' not null comment '用户生日',
	signature varchar(255) default '' not null comment '用户个人签名',
	mobile varchar(16) default '' not null comment '手机号码(唯一)',
	mobile_bind_time int default '0' not null comment '手机号码绑定时间',
	email varchar(100) default '' not null comment '邮箱(唯一)',
	email_bind_time int default '0' not null comment '邮箱绑定时间',
	face varchar(255) default '' not null comment '头像',
	face200 varchar(255) default '' not null comment '头像 200x200x80',
	srcface varchar(255) default '' not null comment '原图头像',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '绑定时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '更新绑定时间',
	remove_status tinyint(2) default '0' null comment '删除状态',
	push_token varchar(50) not null comment '用户设备push_token'
)
comment '用户基础信息表'
;

create table user_extra
(
	uid bigint not null comment '用户 ID'
		primary key,
	vendor varchar(64) default '' not null comment '手机厂商：apple|htc|samsung，很少用',
	client_name varchar(50) default '' not null comment '客户端名称，如hjskang',
	client_version varchar(50) default '' not null comment '客户端版本号，如7.0.1',
	os_name varchar(16) default '' not null comment '设备号:android|ios',
	os_version varchar(16) default '' not null comment '系统版本号:2.2|2.3|4.0|5.1',
	device_name varchar(32) default '' not null comment '设备型号，如:iphone6s、u880、u8800',
	device_id varchar(128) default '' not null comment '设备ID',
	idfa varchar(50) default '' not null comment '苹果设备的IDFA',
	idfv varchar(50) default '' not null comment '苹果设备的IDFV',
	market varchar(20) default '' not null comment '来源',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '绑定时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '更新绑定时间',
	remove_status tinyint(2) default '0' null comment '删除状态',
	extend1 varchar(100) default '' not null comment '扩展字段1',
	extend2 varchar(100) default '' not null comment '扩展字段2',
	extend3 varchar(100) default '' not null comment '扩展字段3'
)
comment '用户额外信息表'
;

create table user_location
(
	uid bigint not null comment '用户ID'
		primary key,
	curr_nation varchar(10) default '' not null comment '所在地国',
	curr_province varchar(10) default '' not null comment '所在地省',
	curr_city varchar(10) default '' not null comment '所在地市',
	curr_district varchar(20) default '' not null comment '所在地地区',
	location varchar(255) default '' not null comment '具体地址',
	longitude decimal(10,6) null comment '经度',
	latitude decimal(10,6) null comment '纬度',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '绑定时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '更新绑定时间',
	remove_status tinyint(2) default '0' null comment '删除状态'
)
comment '用户定位表'
;

create table user_login_log
(
	id bigint auto_increment
		primary key,
	uid bigint default '0' not null comment '用户uid',
	type tinyint(3) unsigned default '1' not null comment '登录方式 第三方/邮箱/手机等',
	command tinyint(3) unsigned default '1' not null comment '操作类型 1登陆成功  2登出成功 3登录失败 4登出失败',
	version varchar(32) default '1.0' not null comment '客户端版本号',
	client varchar(20) default 'dabaozha' not null comment '客户端',
	device_id varchar(64) default '' not null comment '登录时设备号',
	lastip varchar(32) default '' not null comment '登录ip',
	os varchar(16) default '' not null comment '手机系统',
	osver varchar(32) default '' not null comment '系统版本',
	text varchar(200) default '' not null,
	create_time timestamp default CURRENT_TIMESTAMP not null comment '绑定时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '更新绑定时间',
	remove_status tinyint(2) default '0' null comment '删除状态'
)
comment '登陆日志表'
;

create index idx_create_time
	on user_login_log (create_time)
;

create index idx_uid_type_time
	on user_login_log (uid, type, create_time)
;

