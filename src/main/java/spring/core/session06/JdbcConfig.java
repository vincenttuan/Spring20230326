package spring.core.session06;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Jdbc 的 Java 配置檔
@Configuration
@ComponentScan(basePackages = {"spring.core.session06"})
@PropertySource("classpath:db.properties")
public class JdbcConfig {
	
	@Bean
	public ComboPooledDataSource dataSource(Environment env) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(30);
        dataSource.setMaxPoolSize(100);
        dataSource.setMinPoolSize(10);
        dataSource.setAcquireIncrement(3);
        dataSource.setIdleConnectionTestPeriod(60);
		return dataSource;
	}
	
}
