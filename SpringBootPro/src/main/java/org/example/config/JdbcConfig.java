package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Configuration：声明一个类作为配置类，代替xml文件
 * @Bean：声明在方法上，将方法的返回值加入Bean容器，代替<bean>标签
 * @value：属性注入
 * @PropertySource：指定外部属性文件。
 */
@Configuration
//@EnableConfigurationProperties(JDBCProperties.class)//使用时，开启属性类的配置
public class JdbcConfig {
/*  1.使用注解的方式把配置注入进来
    @Autowired
    private JDBCProperties jdbcProperties;//*/

    /*@Bean
    //2.使用调用方法
    //此方法适用于多数次注入
    public DataSource dataSource(JDBCProperties jdbcProperties){

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcProperties.getUrl());
        druidDataSource.setDriverClassName(jdbcProperties.getDriver());
        druidDataSource.setUsername(jdbcProperties.getUsername());
        druidDataSource.setPassword(jdbcProperties.getPassword());
        return druidDataSource;
    }*/

    //3.配置的属性为私用的可以进行这种设置
    //使用该种设置会将查看方法里面的属性与配置文件当中的属性是否一致，一致就注入
    @Bean
    /* 声明要注入的属性前缀，SpringBoot会自动把相关属性通过set方法注入到DataSource */
    //此方法适用于单次注入
    @ConfigurationProperties(prefix = "jdbc")//读取application.properties配置文建里面的配置
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

}
