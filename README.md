## 基于Java接口测试

## 运行
* 第一种方式: 右击cases/xxTest文件
* 第二种方式: 右击testng.xml
* 打jar包 进入根目录 mvn clean package

## 查看报告
右击testng.xml 在test-output下生产index.html

## 项目目录介绍

### apitest
* cases
    * xxTest      //建议以Test结尾，此目录存放用例
* config
    * ExtentTestNGIReporterListener // 测试报告配置
    * TestConfig            // 声明一些常用变量
* utils
    * MySQLUtil        // 数据库连接
    * SelectUserName/SelectUserNameTest 数据库连接测试

### resources
* moco-runner-0.11.0-standalone.jar //moco jar包
* x.json    //moco的一些json数据
* testng.xml    //   用例配置

