package com.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author polaris
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.polaris.mapper")
public class PolarisServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisServeApplication.class, args);
    }

}
