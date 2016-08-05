package net.bac.sample.repository.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gdiazs
 */
@Configuration
@ComponentScan(basePackages = { "net.bac.sample.repository.dao.impl" })
@EnableTransactionManagement
public class DataBaseConfig {
  
  private static String USER = "sa";
  private static String URL = "jdbc:h2:mem:sampledb;"
      + "DB_CLOSE_DELAY=5;TRACE_LEVEL_SYSTEM_OUT=1";
  
  
 
  /**
   * 
   * @return DataSource
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUsername(USER);
    dataSource.setPassword("");
    dataSource.setUrl(URL);
    
    Flyway flyway = new Flyway();
    flyway.setLocations("classpath:db/migration");
    flyway.setDataSource(dataSource);
    flyway.migrate();
    return flyway.getDataSource();
  }

  @Bean
  public DataSourceTransactionManager getDataSourceTransactionManager(
      final DataSource dataSource) {
    DataSourceTransactionManager dstm = new DataSourceTransactionManager();
    dstm.setDataSource(dataSource);
    return dstm;

  }

}