## 基于Java接口测试

## 简介

1.基于Java进行接口测试，使用HttpClient发送请求

2.断言使用testNg进行断言

3.配置使用maven进行配置

4.集成moco，moco接口，在resources目录下`java -jar ./moco-runner-0.11.0-standalone.jar http -p 8888 -c startup1.json`

5.运行testng.xml或者在根目录下mvn clean test 在test-output下生成index.html（测试报告）

## 运行

* 第一种方式: 右击cases/xxTest文件
* 第二种方式: 右击testng.xml
* 第二种方式 进入根目录 mvn clean test

## 查看报告
右击testng.xml 在test-output下生成index.html

## 项目目录介绍

### log
日志输出

### src/main/java/apitest
* cases
    * xxTest      //建议以Test结尾，此目录存放用例
* config
    * ExtentTestNGIReporterListener // 测试报告配置
    * TestConfig            // 声明一些常用变量
* utils
    * MySQLUtil        // 数据库连接
    * SelectUserName/SelectUserNameTest 数据库连接测试

### src/main/resources
* moco-runner-0.11.0-standalone.jar //moco jar包
* x.json    //moco的一些json数据
* log4j.properties //日志配置

### test-output
* index.html  //测试报告

### pom.xml
依赖

### testng.xml
testng.xml    //   用例配置

