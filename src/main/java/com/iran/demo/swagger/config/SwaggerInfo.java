package com.iran.demo.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: IranLin
 * @Create Date: 2019/11/25 21:04
 * @Description: swagger配置信息
 **/
@Component
@ConfigurationProperties(prefix = "swagger")
@PropertySource("classpath:/config/swagger.properties")
@Data
public class SwaggerInfo {
    private String basePackage;
    private String antPath;
    private String title = "HTTP API";
    private String description = "Swagger 自动生成接口文档";
    private String version ;
    private Boolean enable;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
    private String license;
    private String licenseUrl;
}
