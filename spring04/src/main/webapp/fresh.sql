create database fresh default character set utf8 collate utf8_bin;   -- collate：校对

use fresh;

-- 会员信息表
drop table if exists memberInfo;
create table if not exists memberInfo(
	mno int primary key auto_increment, -- 会员编号
	nickname varchar(100) not null unique, -- 会员名，昵称
	pwd varchar(200) not null, -- 密码
	tel varchar(15) not null unique, -- 手机号码
	email varchar(50) not null unique,  -- 邮箱
	photo varchar(100), -- 用户图像
	realName varchar(100), -- 真实姓名
	sex varchar(4) default '男',
	regDate datetime, -- 注册日期
	status int default 1 -- 账号状态
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;   -- InnoDB：是MySQL的数据库引擎之一。事务型数据库的首选引擎，支持ACID事务，支持行级锁定。
alter table memberInfo auto_increment=10001;			-- InnoDB是为处理巨大数据量时的最大性能设计。MyISAM：不支持事务


-- 商品类型
drop table if exists typeInfo;
create table if not exists typeInfo(
	tno int primary key auto_increment, -- 类型编号
	tname varchar(100) not null unique, -- 类型名称
	status int -- 状态
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

-- 二级类目表
drop table if exists typeItemInfo;
create table if not exists typeItemInfo(
	tino int primary key auto_increment, -- 类型编号
	tname varchar(100) not null unique, -- 类型名称
	tno int, -- 所属一级分类
	status int, -- 状态
	constraint FK_typeItemInfo_tno foreign key(tno) references typeInfo(tno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;


-- 商品信息表
drop table if exists goodsInfo;
create table if not exists goodsInfo(
	gno int primary key auto_increment, -- 商品编号
	gname varchar(200) not null, -- 商品名称
	tino int, -- 所属类型
	price decimal(8,2), -- 商品单价
	intro varchar(1000), -- 商品简介 
	balance int, -- 商品库存
	unit varchar(50), -- 商品单位
	place varchar(200), -- 商品产地
	qualityPeriod varchar(40), -- 保质期
	weight decimal(6,2),  -- 净重
	pics varchar(2000), -- 商品图片
	descr text, -- 商品描述
	constraint FK_goodsInfo_tino foreign key(tino) references typeItemInfo(tino)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

-- 收货地址信息
drop table if exists addrInfo;
create table if not exists addrInfo(
	ano int primary key auto_increment, -- 地址编号
	mno int, -- 会员编号
	name varchar(100) not null, -- 收货人姓名
	tel varchar(15) not null, -- 收货人联系方式
	province varchar(100) not null, -- 省
	city varchar(100) not null, -- 市
	area varchar(100) not null, -- 区
	addr varchar(200) not null, -- 详细地址楼栋门牌信息
	status int, -- 是否是默认收获地址
	constraint FK_addrInfo_mno foreign key(mno) references memberInfo(mno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

-- 支付方式表
drop table if exists paymentInfo;
create table if not exists paymentInfo(
	pno int primary key auto_increment, -- 支付方式编号
	pname varchar(100) not null unique, -- 支付方式名称
	url varchar(400), -- 接口地址
	status int -- 状态
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

-- 快递公司信息 ？？？

-- 订单表
drop table if exists orderInfo;
create table if not exists orderInfo(
	ono varchar(100) primary key, -- 订单编号
	odate datetime, -- 订购日期
	ano int, -- 收货地址信息
	price decimal(8,2), -- 订单总价
	status int, -- 订单状态
	sdate datetime, -- 发货日期
	rdate datetime, -- 收货日期
	pno int, -- 支付方式
	invoice int, -- 是否已经开发票
	cancelDate datetime, -- 取消日期
	reason varchar(400), -- 取消原因
	spare varchar(200), -- 备用字段
	reserve varchar(200), -- 备用字段
	constraint FK_orderInfo_ano foreign key(ano) references addrInfo(ano),
	constraint FK_orderInfo_pno foreign key(pno) references paymentInfo(pno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;


-- 订单详细
drop table if exists orderItemInfo;
create table if not exists orderItemInfo(
	oino int primary key auto_increment, -- 订单详细编号
	ono varchar(100), -- 所属订单
	gno int, -- 商品编号
	num int, -- 购买数量
	price decimal(8,2), -- 购买单价
	status int, -- 状态
	spare varchar(200), -- 备用字段
	reserve varchar(200), -- 备用字段
	comments int, -- 评价状态 ???
	constraint FK_orderItemInfo_ono foreign key(ono) references orderInfo(ono),
	constraint FK_orderItemInfo_gno foreign key(gno) references goodsInfo(gno)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

-- 评论信息表
drop table if exists commentInfo;
create table if not exists commentInfo(
	cno int primary key auto_increment, -- 评论编号
	oino int, -- 订单详细编号
	score int, -- 评分
	cdate datetime, -- 评论时间
	pics varchar(400), -- 商品实物图片
	content varchar(1000), -- 评论内容
	constraint FK_commentItemInfo_oino foreign key(oino) references orderItemInfo(oino)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;


-- 广告位信息表  什么时候到什么时候在哪个广告位打什么广告


-- 活动信息表
