package cn.edu.xmu.examonline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 应用程序启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.edu.xmu.examonline.mapper")
@EnableSwagger2
public class ExamonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamonlineApplication.class, args);
    }

}
