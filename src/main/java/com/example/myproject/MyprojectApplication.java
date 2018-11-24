package com.example.myproject;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author 34924
 */
@SpringBootApplication
public class MyprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyprojectApplication.class, args);
    }

    @Autowired
    private Environment environment;

    /**
     * destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
     * @return
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        //用户名
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        //密码
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);
        //初始化时建立物理连接的个数
        dataSource.setMaxActive(20);
        //最大连接池数量
        dataSource.setMinIdle(0);
        //最小连接池数量
        dataSource.setMaxWait(60000);
        //获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");
        //用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);
        //申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);
        //建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);
        //是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }
}
