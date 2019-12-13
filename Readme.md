# 山师二手书交易商城APP

### 系统概要

大学生是一个阅读书籍广泛的群体，不论是教科类书籍还是休闲类书籍，日复一日总有许多积压在身边，大多不会再反复阅读。一部分学生会选择收藏这些书籍，但是却占用了相当大空间；还有一部分同学会将这些书籍销毁丢弃，或者低价贱买，这样就造成了资源的浪费；另一部分同学会将书籍以原价的折扣价格转卖，这样既节省了空间有实现了资源的循环利用。然而买卖双方直接交涉，通过qq群，摆放摊位，等到买方或卖方产生相应需求，双方交涉达成交易。但这种方法比较麻烦，而且及时性较差。所以在网上创建一个二手书交易管理系统是很有必要的。  在高校二手书管理系统中，用户分为一般用户即求购者和出售者，以及超级用户系统管理员。一般用户对系统具有一般权限，需要通过注册，登陆方能进入系统；超级用户系统管理员对系统具有最高权限，通过登录进入系统，对系统进行管理和维护。求购者在系统中发布图书求购信息，对出售信息进行查询，如果有自己需要的图书，就可以与出售者进行交涉；出售者在系统中发布图书出售信息；图书管理员对出售信息进行整理，更新数据库，链接求书者，进行版内留言。

### 用户分类

本系统的用户可以分为以下三类：  

 求购者：此类用户可能会在在淘书店论坛上发布求购图书的帖子，或者回复出售者发布的求购贴以购买自己需要的图书，此类用户对软件系统具有一般权限。 

  出售者：此类用户可能会在在淘书店论坛上发布出售图书的帖子，或者回复求购者发布的求购贴以出售自己的图书，此类用户对软件系统具有一般权限。

 软件管理员：此类用户对软件全方面进行管理，保证软件运行的安全，对各个用户以及他们发布的信息进行审核，更新数据库，此类用户对软件系统具有最高权限。

### 功能实现
1576205777625.png 


##### 用户注册登陆模块

##### 书籍展示模块

##### 发布信息模块

##### 书籍搜索模块



### 

## 数据库

| 类名              | 功能描述                                                     |
| ----------------- | ------------------------------------------------------------ |
| User              | 用户，本系统中所有业务类都是围绕User进行设计的               |
| Book              | 书，用户可以选择不同的书，加入购物车中进行购买               |
| Order             | 订单，订单分为多个状态，例如交易成功，交易失败，待支付，已支付，已发货，已收货等状态 |
| OrderItem         | 订单明细，一个订单对象对应多个订单明细对象，每个订单明细对象有关联着礼品对象 |
| IndexPage         | Android APP首页配置                                          |
| IndexPageResource | Android APP首页的图片等资源                                  |



##### User

| 成员名         | 类型    | 内容         |
| -------------- | ------- | ------------ |
| id             | int     | id           |
| name           | String  | 用户名       |
| username       | String  | 登陆名       |
| password       | String  | 密码         |
| headid         | Sting   | 头像id       |
| school         | String  | 学校         |
| college        | String  | 学院         |
| professional   | String  | 专业         |
| enrollmentyear | String  | 入学年份     |
| education      | String  | 学历         |
| mobile         | String  | 手机         |
| mobileToken    | String  | 登陆令牌     |
| realName       | String  | 真实姓名     |
| sex            | String  | 性别         |
| bindStatus     | Integer | 手机绑定状态 |

##### 

##### Book

| 成员名          | 类型    | 内容       |
| --------------- | ------- | ---------- |
| id              | int     | id         |
| pictureid       | String  | 书籍照片id |
| name            | String  | 书名       |
| publishinghouse | String  | 出版社名   |
| writer          | String  | 作者       |
| franking        | int     | 邮费       |
| price           | int     | 价格       |
| sOb             | boolean | 买或者是买 |
| exsit           | boolean | 是否还有   |

