# helloworld springboot nacos

> SpringBoot 集成 nacos 样例项目，部署在 Docker 环境下。

## 一、安装 Docker 环境。下载nacos软件包

注意：Docker 环境可以安装在 Linux 系统内，也可以安装在 Windows 环境内。

## 二、Docker 环境内安装并启动 nacos

执行如下指令启动 nacos（注意：如果本地没有下载过该 image 会自动下载，耐心等待即可）
> docker run -d --name docker-nacos -p 8848:8848 --env MODE=standalone nacos/nacos-server:latest

## 三、验证 nacos 启动成功

访问 http://localhost:8848/nacos/ 用户名和密码均为nacos，登陆正常即可。

## 四、启动多个Provider

定位到 com.mfanw.helloworld.nacos.NacosProviderApplication 启动多次，注意每启动一次要修改一下端口号，确保启动端口号不重复。<br />
修改端口号方法：打开application.yml文件，修改server:port:后的端口号

## 五、启动Consumer进行验证

定位到 com.mfanw.helloworld.nacos.NacosConsumerApplication 启动，注意观察最后的消息，如果执行无异常且接收到消息则表示验证成功
