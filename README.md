# helloworld nacos

> SpringBoot 集成 nacos 样例项目

## 一、下载nacos软件包

注意：需要下载v1版本的nacos软件包，建议下载 nacos-server-1.4.0.zip
https://github.com/alibaba/nacos/releases/tag/1.4.0

## 二、启动nacos

解压nacos-server-1.4.0.zip并运行bin/startup.sh <br />
注意：运行需要选择 standalone 模式，运行命令.\startup.cmd -m standalone

## 三、启动多个Provider

定位到 com.mfanw.helloworld.nacos.NacosProviderApplication 启动多次，注意每启动一次要修改一下端口号，确保启动端口号不重复。<br />
修改端口号方法：打开application.yml文件，修改server:port:后的端口号

## 四、启动Consumer进行验证

定位到 com.mfanw.helloworld.nacos.NacosConsumerApplication 启动，注意观察最后的消息，如果执行无异常且接收到消息则表示验证成功
