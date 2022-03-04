package org.example.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*@ConfigurationProperties(prefix = "jdbc")//读取application.properties配置文建里面的配置
@Data*/
public class JDBCProperties {

    private String url;

    private String driver;

    private String username;

    private String password;
}
