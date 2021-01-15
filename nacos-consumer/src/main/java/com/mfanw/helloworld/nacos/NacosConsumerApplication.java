package com.mfanw.helloworld.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费端
 *
 * @author mengwei
 */
@RestController
@SpringBootApplication
public class NacosConsumerApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(NacosConsumerApplication.class);

    @NacosInjected
    private NamingService namingService;

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            // 根据服务名从注册中心获取一个健康的服务实例
            Instance instance = namingService.selectOneHealthyInstance("provider-service");
            // 这里只是为了方便才新建RestTemplate实例
            RestTemplate template = new RestTemplate();
            String url = String.format("http://%s:%d/hello/consumer", instance.getIp(), instance.getPort());
            String result = template.getForObject(url, String.class);
            LOGGER.warn(String.format("请求URL:%s,响应结果:%s%n", url, result));
            Thread.sleep(1000);
        }
    }
}