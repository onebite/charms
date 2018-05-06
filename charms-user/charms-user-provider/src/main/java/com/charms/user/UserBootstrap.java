package com.charms.user;

import com.charms.common.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootApplication
@PropertySource("classpath:./conf/application.properties")
@EnableAutoConfiguration
@ComponentScan({"com.charms.datasource.config.readwrite","com.charms.user.dao.mapper"})
public class UserBootstrap {

    @Bean
    CountDownLatch closeLatch(){

        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new SpringApplicationBuilder()
                .sources(UserBootstrap.class)
                .web(false)
                .run(args);

        log.info("用户服务启动成功");

        SpringContextUtils springContextUtil = springContextUtil();
        springContextUtil.setApplicationContext(context);

        CountDownLatch closeLatch = context.getBean(CountDownLatch.class);
        closeLatch.await();
    }


    @Bean("springContextUtil")
    public static SpringContextUtils springContextUtil() {

        return new SpringContextUtils();
    }
}
