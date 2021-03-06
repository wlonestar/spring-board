## 项目背景

项目围绕“百年荣光路，最美看今朝”的主题，实现用户注册登录后发表对党100周岁的祝福的留言，统计留言中的高频词汇，并进行类似词云的显示。



## 项目概述

本项目基于 Spring boot 实现。

根据需求分析得出，网页包括登录注册页面，首页，留言页面，高频词展示页面。我们要实现的内容包括用户登录，播放红歌，留言，查看高频词等。

我们使用了 springMVC 模式进行开发，将每位用户的用户名、密码和留言存到数据库中，编写程序对数据库中的留言进行高频词统计，再通过前端显示，即可达到所需的效果。



## 后端技术具体实现过程

### 1. 创建数据库表

1. 使用MySQL命令行创建数据库

2. 创建用户表 user ，包括 id（主键）, username, password, token 四列，记录用户注册登录信息，token 在注册时随机生成
3. 创建留言表 comment ，包括 id（主键）, username, comment, time 四列，time 为发布留言的时间



### 2. 构建项目

1. 创建 Spring boot Web 项目

    1. 修改 pom.xml 文件，添加 web, MySql, druid, MyBatis, thymeleaf 等必要依赖
    2. 编写 application.yml 文件，配置服务器端口、数据库驱动、数据库连接池、指定 mapper.xml 路径

2. 连接数据库

    使用 MySQL Driver ，设置时区，连接数据库



### 3. 实现 mvc 三层模型

1. 新建 model

    新建 User 和 Comment 实体类，添加数据库中对应的属性，导入 Lombok 依赖使用注解自动生成有参构造、无参构造和 getter() and setter() 方法

2. 新建 mapper

    创建 UserMapper 和 CommentMapper ，把数据库映射成 Java 类，使用sql语句注解实现增删改查基本功能

3. 新建 controller

    新建 LoginController、RegisterController、IndexController 控制器，确定接口请求模式、数据类型

4. 利用 thymeleaf 模板引擎整合前端页面

    导入前端静态资源 html, css, js 以及图片、视频、音乐等，注入 thymeleaf 标签，实现页面动态显示

5. 增加高频词统计算法，增加高频词展示页面



## 前端技术具体实现过程

### 1. 实现网页布局

1. 通过div、ul、a等标签（以及调用bootstrap）将网页基本需要进行布局
2. 通过css将页面渲染以及进一步布局成我们所需要的样子



### 2. 实现页面交互特效

1. 引进jquery库方便简化js的调用
2. 通过绑定事件完成页面交互特效



### 3. 实现前后端交互

1. 通过引进jquery库简化ajax的调用

2. 通过使用ajax与后端进行数据交互从而达到不刷新页面来进行注册与登录的交互页面



## 网页留言板提取高频词功能实现

1.获取留言板数据后，在python脚本里通过jieba库进行初步分词（全模式）

2.通过自定义停用词来优化分词结果



## 项目总结与展望

这个项目目前还只能实现最简单的功能，有些异常并没有考虑进去进行处理，有些部分实现的效果可能也不是很好，但从项目的设计构思到尝试实现的过程中，我们小组成员意识到了团队协作的重要性，明确各自职责，分配每个人的任务，先去学习，再尝试实现，最终整合起来测试运行。

通过此次的web应用开发，我们大概了解到了web开发的流程，意识到了web开发领域有大量的东西需要我们学习，我们也在做项目的过程中学习了很多新的、学校不会教的知识，对我们今后的学习一定会有很大的帮助。这个项目虽然简陋，但也实现了基本的功能，有机会可以再进行改进和优化，实现更好的效果。