# 背英语单词
如何使用在前端界面有说明

# 架构
* backend为后端代码
* frontend为前端代码

# 快速入门

## application.yml里mysql数据库信息配好
``` xml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/words?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: root
```

## 运行sql，初始化词典表信息

目录在 backend/src/resources/sql

## 运行程序
打开localhost/index.html
