## 基于Java接口测试

## 简介

1.基于Java进行接口测试,使用HttpClient发送请求,封装get和post请求,post请求支持form-data和json两种格式,这样定义一个接口方法时，
只要关注url,参数即可。比如发送使用**post请求**发送form-data格式的参数时调用HttpUtils下面的postListParams方法,发送json格式的参数时
调用HttpUtils下面的postJsonParams方法,使用**get请求**调用HttpUtils下面的doGet方法。


2.断言使用testNg进行断言，

3.使用testNg进行参数化，参数化的时候可以使用数据库查询的数据

4.配置使用maven进行配置

5.集成moco，moco接口，在resources目录下`java -jar ./moco-runner-0.11.0-standalone.jar http -p 8888 -c startup1.json`

6.运行testng.xml或者在根目录下mvn clean test 在test-output下生成index.html（测试报告）

## 运行

* 第一种方式: cases/xxTest下进行执行
* 第二种方式: 右击testng.xml
* 第三种方式 进入根目录 mvn clean test

## 查看报告

* 第一种方式: 右击testng.xml
* 第二种方式 进入根目录 mvn clean test 

在test-output下生成index.html

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

