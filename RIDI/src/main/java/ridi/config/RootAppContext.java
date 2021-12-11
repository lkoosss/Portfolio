package ridi.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("ridi.model.book")
@ComponentScan("ridi.model.member")
@ComponentScan("ridi.model.orders")
@ComponentScan("ridi.model.qna")
@ComponentScan("ridi.model.review")
public class RootAppContext {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@152.70.233.96:1521:xe");
		hikariConfig.setUsername("LKOOSSS");
		hikariConfig.setPassword("tjdtlr20");
		
		
		hikariConfig.setMaximumPoolSize(80);
//		hikariConfig.setConnectionTimeout(5000000);
//		hikariConfig.setIdleTimeout(6000000);
		hikariConfig.setKeepaliveTime(240000);
		
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:ridi/mybatis/config.xml"));
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:ridi/mybatis/mapper/*.xml"));

		
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
	}
	
	
}
