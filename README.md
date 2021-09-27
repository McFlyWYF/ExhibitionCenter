# ExhibitionCenter
# 会展中心管理系统
## 1  系统设计
### 1.1设计目标

```
在学习了数据库原理和SQL Server 2008数据库管理系统后，采用Java编程语言开发工具，设计并实现会展中心管理系统。

本课程的目的是培养学生数据库技术的综合应用能力，通过设计开发一个小型的数据库管理系统，将原理与应用相结合，锻炼学生实际问题的分析、设计与编程能力。
设计过程：采用设计总体框图、数据库结构和功能结构图。

会展中心管理系统的设计，可以实现会展中心管理人员对会展中心的方便管理，以及会展信息的发布。客户可以通过系统来预定展馆，预定门票，展品采购，使操作更加集中，方便使用。该系统操作方便，适合大多数人操作使用。
```

### 1.2 需求分析

```
设计内容:
(1)对“会展中心管理系统”进行需求调研，完成概念模型和逻辑结构设计；
(2)建立“会展中心管理系统”数据库；
(3)编程实现“会展中心管理系统”，主要包括客户管理员注册登录，会展信息管理，对展馆、展商、展品的增加删除查询；会展信息查询，展馆预约；门票预定；展品采购。

设计要求：
(1) 采用图形化界面；
(2) 操作方便、界面友好；
(3) 撰写课程设计说明书。

数据库安全性：数据库安全性指保护数据库以防止不合法使用所造成的数据泄露、更改或破坏。对本系统中管理员和客户的账号和密码以及客户的身份证号进行加密，防止其他用户窃取。用户登录设置有两个客户端，即客户和管理员，身份不同，进入的系统不同，相应的操作数据库的权限也不同。

数据库完整性：数据库完整性包括实体完整性，参照完整性和用户定义完整性。对每一个表中都设置有相应的主码约束，检查主码是否唯一，如果不唯一则拒绝插入或修改。对表设置列值非空，列值唯一，检查列值是否满足一个条件表达式。在表级定义有外码约束，将两个表中的相应元组联系起来。
```

### 1.3开发和运行环境选择

```
开发工具： 前台开发语言为Java，后台数据库为SQL Server2017
运行环境：windows10及更高的操作系统
```

## 2  数据库设计
### 2.1数据库概念设计
![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB1.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB2.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB5.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB4.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB6.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB3.png)

### 2.2数据库逻辑结构设计

* 展馆表

| 列名        | 数据类型    |  说明  | 约束 ｜
| --------   | -----:   | :----: | ----- ｜
| Saccount        | CHAR(20)      |   登录名    | PRIMARY KEY ｜
| Spwd        | CAHR(20)      |   密码    | NOT NULL ｜

* 展品表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Pno        | CHAR(20)      |   展品编号    | PRIMARY KEY
    | Pname        | CAHR(20)      |   展品名称    | NOT NULL
    | Parea  | INT | 面积 | |
    | Paddress | CHAR(20) | 地址 | |
    | Person | CHAR(20) | 负责人 | |
    | Pnum | INT | 展位数 | NOT NULL |

* 展商表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Bno        | CHAR(20)      |   展商编号    | PRIMARY KEY
    | Bname        | CAHR(20)      |   展商名称    | NOT NULL
    | Bid  | CHAR(50) | 身份证号 | NOT NULL,UNIQUE |
    | Bprofession | CHAR(20) | 职业 | |
    | Bworkplace | CHAR(20) | 工作单位 | |
    | Bphone | CHAR(20) | 手机号 | NOT NULL |

* 门票预定表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Ano        | CHAR(20)      |  订单编号    | PRIMARY KEY
    | Aname        | CAHR(20)      |   姓名    | NOT NULL
    | Asex  | CHAR(10) | 性别 | ‘男’‘女’ |
    | Aprofession | CHAR(20) | 职业 | |
    | Mno | CHAR(20) | 展会编号 | NOT NULL|

* 展会信息表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Mno        | CHAR(20)      |   展会编号    | PRIMARY KEY
    | Mname        | CAHR(20)      |   展会名称    | NOT NULL
    | Bno  | CHAR(10) | 展商编号 | FOREIGN KEY |
    | Tno | CHAR(20) | 展品编号 | FOREIGN KEY|
    | Pno | CHAR(20) | 展馆编号 | NOT NULL|
    | Mtime | DATE | 时间 | NOT NULL |
    | Mprice | INT | 门票价格 | NOT NULL |

* 采购商表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Sno        | CHAR(20)      |  订单编号    | PRIMARY KEY
    | Sname        | CAHR(20)      |   姓名    | NOT NULL
    | Tno  | CHAR(10) | 展品编号 | NOT NULL |
    | Stime | DATE | 时间 | | |


* 展馆预定表

| 列名        | 数据类型    |  说明  | 约束
    | --------   | -----:   | :----: |
    | Rno        | CHAR(20)      |  预定编号    | PRIMARY KEY
    | Pno        | CAHR(20)      |   展馆编号    | NOT NULL
    | Bno  | CHAR(10) | 展商编号 | NOT NULL|
    | Rtime | DATE | 时间 | |
    | Rnum | INT | 展位数 | NOT NULL|
    | Bname | CHAR(20) | 展商姓名 | NOT NULL|

## 3  会展中心管理系统详细设计
### 3.1 功能描述
```
会展中心管理系统具体包含如下几个功能：
管理员功能：
（1）录入展商，展馆，展品，展会的信息。
（2）对展商，展品，展馆的信息进行增删改查。
客户功能：
（1）查询展会，展商，展品，展馆信息。
（2）预约展馆，预订门票，展品采购。
```
### 3.2 系统模块图
```
主要负责整个会展中心管理系统的框架搭建和逻辑设计。
功能描述：用户打开系统，选择不同的权限和输入不同的用户名进入不同的系统，如果用户名或密码输入正确，
进入系统之后，管理员的操作有会展信息管理、展馆管理、展商管理和展品管理。
客户的操作有展品采购、展馆预约、门票预定和会展信息查询。
操作完成之后，退出系统，系统功能模块图如图3.2所示。
```
![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB7.png)

###  实现界面及代码

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB15.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB8.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB9.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB10.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB11.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB12.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB13.png)

![Image Text](https://raw.github.com/wangyufei1006/ExhibitionCenter/master/image/DB14.png)

### 创建数据库代码
```sql
创建数据库相关代码。
CREATE DATABASE HZZX;
--操作信息表
CREATE TABLE Operator(
Sacc CHAR(20) PRIMARY KEY,--登录名
Spwd CHAR(20) NOT NULL,--密码
);
--展商表
CREATE TABLE Business(
Bno CHAR(10) PRIMARY KEY,--展商编号
Bname CHAR(20) NOT NULL,--姓名
Bid CHAR(50) NOT NULL UNIQUE,--身份证号
Bwork CHAR(20),--职业
Bworkplace CHAR(20),--工作单位
Btel CHAR(20)--手机号
);
--展品表
CREATE TABLE Thing(
Tno CHAR(10) PRIMARY KEY,--展品编号
Tname CHAR(20),--展品名称
Tkind CHAR(10),--类别
Tprice INT,--售价
Tarea INT--规格
IsBuy CHAR(5)--售出状态
);
--展馆表
CREATE TABLE Place(
Pno CHAR(10) PRIMARY KEY,--展馆编号
Pname CHAR(20),--展馆名称
Parea INT,--面积
Padd CHAR(20),--地址
Ppeo CHAR(20),--负责人
Pnum INT--展位数
);
--门票预定表
CREATE TABLE Ticket
(Ano CHAR(10) PRIMARY KEY,--观众编号
Aname CHAR(20),--姓名
Asex CHAR(5) CHECK (Asex IN ('男','女')),--性别
Awork CHAR(10),--职业
Mno CHAR(10)--展会编号);
--展会信息表
CREATE TABLE Meeting
(Mno CHAR(10)PRIMARY KEY,--展会编号
Mname CHAR(20),--展会名称
Bno CHAR(10),--展商编号
Tno CHAR(10),--展品编号
Pno CHAR(20),--展馆编号
Mtime CHAR(20),--时间
FOREIGN KEY(Bno) REFERENCES Business(Bno),
FOREIGN KEY(Tno) REFERENCES Thing(Tno));
--采购商表
CREATE TABLE Shop
(Sno CHAR(10) PRIMARY KEY,--采购商编号
Sname CHAR(20),--姓名
Tno CHAR(10),--展品编号
Stime DATE,--采购时间
FOREIGN KEY(Tno) REFERENCES Thing(Tno));
--展馆预定表
CREATE TABLE Reserve
(RNO CHAR(10) PRIMARY KEY,--订单编号
Pno CHAR(10),--展馆编号
Bno CHAR(10),--展商编号
Bname CHAR(20),--展商姓名
Rtime DATE NOT NULL,--时间
Rnum INT NOT NULL,--展位数
FOREIGN KEY(Pno) REFERENCES Place(Pno),
FOREIGN KEY(Bno) REFERENCES Business(Bno));
//创建视图
CREATE VIEW v_reserve(no,p_name,name,time,num) AS SELECT Reserve.RNO,Place.Pname,Reserve.Bname,Reserve.Rtime,Reserve.Rnum FROM Reserve,Place WHERE Place.Pno = Reserve.Pno;

CREATE VIEW v_ticket(no,t_name,sex,work,m_name,p_name,price) AS SELECT Ano,Aname,Asex,Awork,Meeting.Mname,Place.Pname,Meeting.Mprice FROM Ticket,Meeting,Place WHERE Ticket.Mno = Meeting.Mno and Meeting.Pno = Place.Pno;

CREATE VIEW [dbo].[v_shop] (no,s_name,t_name,kind,time,price) AS SELECT Shop.Sno,Shop.Sname,Thing.Tname,Thing.Tkind,Shop.Stime,Thing.Tprice FROM  Shop,Thing WHERE Shop.Tno = Thing.Tno;
```

## 参考文献
```
[1] 《数据库原理及应用》 钱雪忠主编 北京邮电大学出版社 2007.8 第二版
[2] 《SQL server 2000数据仓库与Analysis Services》 Bain T著 中国电力出版社 2003
[3] 《数据库系统概论》 王珊 萨师煊 编著 高等教育出版社 2014.9 第五版
[4] 《数据库技术与联机分析处理》 王珊主编 北京科学出版社 1998
[5]  张桂珠 刘丽 陈爱国 Java面向对象程序设计（第2版）北京邮电大学出版社
[6]  毕广吉 Java程序设计实例教程[M]  北京：冶金工业出版社，2007年
```

