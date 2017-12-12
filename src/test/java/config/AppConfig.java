package config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.kossine.ims")
@TestPropertySource(locations="classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
 
 /*   @Override
    public void configureDefaultServletHandling(
      DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/html/");
        bean.setSuffix(".html");
        return bean;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/javascript/");
    }
    */
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ret = new DriverManagerDataSource();
        ret.setDriverClassName("com.mysql.jdbc.Driver");
        ret.setUsername("root");
        ret.setPassword("root@lamp");
        ret.setUrl("jdbc:mysql://localhost:3306/ims");
        return ret;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean getEMF() {
    
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPersistenceUnitName("ims");
        emf.setJpaVendorAdapter(getHibernateAdapter());
            Properties jpaProperties = new Properties();
           jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
           jpaProperties.put("hibernate.hbm2ddl.auto", "update");
           jpaProperties.put("hibernate.show_sql", "true");
           jpaProperties.put("hibernate.format_sql","false");
         emf.setJpaProperties(jpaProperties);
      return emf;
    }
    	
	@Bean
	@Autowired
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException{
		
		JpaTransactionManager jpaTransaction = new JpaTransactionManager();
		jpaTransaction.setEntityManagerFactory(emf);
		
		return jpaTransaction;
	}
	 
    @Bean
    public JpaVendorAdapter getHibernateAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }
 
}