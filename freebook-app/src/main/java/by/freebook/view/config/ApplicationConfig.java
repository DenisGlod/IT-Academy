package by.freebook.view.config;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("by.freebook")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "by.freebook.dao.repository")
@PropertySource("classpath:db.properties")
public class ApplicationConfig {

    @Value("${url}")
    private String url;

    @Value("${hbm2ddl.charset_name}")
    private String hbm2ddlCharsetName;

    @Value("${driver_class}")
    private String driverClass;

    @Value("${connection.username}")
    private String user;

    @Value("${connection.password}")
    private String password;

    @Value("${current_session_context_class}")
    private String currentSessionContextClass;

    @Value("${dialect}")
    private String dialect;

    @Value("${hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hbm2ddl.import_files}")
    private String hbm2ddlImportFiles;

    @Value("${hibernate.default_catalog}")
    private String defaultCatalog;

    @Value("${hibernate.default_schema}")
    private String defaultSchema;

    @Value("${show_sql}")
    private String showSql;

    @Value("${format_sql}")
    private String formatSql;

    @Value("${c3p0.min_size}")
    private String c3p0MinSize;

    @Value("${c3p0.max_size}")
    private String c3p0MaxSize;

    @Value("${c3p0.timeout}")
    private String c3p0Timeout;

    @Value("${c3p0.acquire_increment}")
    private String c3p0AcquireIncrement;

    @Value("${c3p0.idle_test_period}")
    private String c3p0IdleTestPeriod;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPersistenceUnitName("jpa-unit");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("by.freebook.dao.entity");
        emf.setJpaProperties(jpaProperties());
        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.charset_name", hbm2ddlCharsetName);
        props.setProperty("hibernate.current_session_context_class", currentSessionContextClass);
        props.setProperty("hibernate.dialect", dialect);
        props.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        props.setProperty("hibernate.hbm2ddl.import_files", hbm2ddlImportFiles);
        props.setProperty("hibernate.default_catalog", defaultCatalog);
        props.setProperty("hibernate.default_schema", defaultSchema);
        props.setProperty("hibernate.show_sql", showSql);
        props.setProperty("hibernate.format_sql", formatSql);
        props.setProperty("hibernate.c3p0.min_size", c3p0MinSize);
        props.setProperty("hibernate.c3p0.max_size", c3p0MaxSize);
        props.setProperty("hibernate.c3p0.timeout", c3p0Timeout);
        props.setProperty("hibernate.c3p0.acquire_increment", c3p0AcquireIncrement);
        props.setProperty("hibernate.c3p0.idle_test_period", c3p0IdleTestPeriod);
        return props;
    }
}
