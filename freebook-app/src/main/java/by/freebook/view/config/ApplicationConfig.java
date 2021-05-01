package by.freebook.view.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Slf4j
@Configuration
@ComponentScan("by.freebook")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "by.freebook.dao.repository")
@PropertySource("classpath:db.properties")
public class ApplicationConfig {

    @Value("${jndi}")
    private String jndi;

    @Value("${hbm2ddl.charset_name}")
    private String hbm2ddlCharsetName;

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

    @SneakyThrows
    @Bean
    public HikariDataSource dataSource() {
        return new JndiTemplate().lookup(jndi, HikariDataSource.class);
    }

    @Bean
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.current_session_context_class", currentSessionContextClass);
        props.setProperty("hibernate.dialect", dialect);
        props.setProperty("hibernate.hbm2ddl.charset_name", hbm2ddlCharsetName);
        props.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        props.setProperty("hibernate.hbm2ddl.import_files", hbm2ddlImportFiles);
        props.setProperty("hibernate.default_catalog", defaultCatalog);
        props.setProperty("hibernate.default_schema", defaultSchema);
        props.setProperty("hibernate.show_sql", showSql);
        props.setProperty("hibernate.format_sql", formatSql);
        return props;
    }
}
