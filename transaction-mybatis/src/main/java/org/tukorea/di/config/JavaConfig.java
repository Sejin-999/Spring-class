package org.tukorea.di.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"org.tukorea.di.persistence", "org.tukorea.di.service"})

public class JavaConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setMaxActive(5);
		return dataSource;
	}

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());		// dataSource() @Bean 메서드를 불러서 객체 취득 후 생성자 인젝션 
    }																 
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
    	// dataSource, applicationContext @Bean 메서드를 인수를 통해 객체 취득 = @Autowired 설정 의미  
        SqlSessionFactoryBean sqlSessionFactory  = new SqlSessionFactoryBean();
        sqlSessionFactory .setDataSource(dataSource);
        sqlSessionFactory .setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactory .setMapperLocations(applicationContext.getResources("classpath:mappers/*Mapper.xml"));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) { // sqlSessionFactory @Bean 메서드를 인수를 통해 객체 취득 = @Autowired 설정 의미
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}