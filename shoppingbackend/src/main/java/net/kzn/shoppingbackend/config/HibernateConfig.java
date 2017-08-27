package net.kzn.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"net.kzn.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	public final static String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
	public final static String DATABASE_USERNAME = "system";
	public final static String DATABASE_PASSWORD = "system1";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		// providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;

	}

	// SessionFactory Bean will be available

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}

}
