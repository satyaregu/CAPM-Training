package configuration;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.mapping.Array;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import com.hikari.HikariDataSource;

import ch.qos.logback.classic.Logger;

@Configuration
public class DBConfig extends AbstractCloudConfig {

    org.slf4j.Logger cloudFoundryDataSourceConfigLogger = LoggerFactory.getLogger(this.getClass());

    @Value("${vcap.services.hanaschema.credentials.user}")
    private String username;

    @Value("${vcap.services.hanaschema.credentials.password}")
    private String password;

    @Value("${vcap.services.hanaschema.credentials.url}")
    private String hostname;

    @Value("${vcap.services.hanaschema.credentials.port}")
    private String port;

    @Value("${vcap.services.hanaschema.credentials.schema}")
    private String schemaname;

    @Bean
    public DataSource dataSource(){
        List<String> dataSourceNames = Arrays.asList("BasicDbcpPooledDataSourceCreator",
                                                        "TomcatJdbcPooledDataSourceCreator",
                                                        "HikariCpPooledDataSourceCreator",
                                                        "TomcatDbcpPooledDataSourceCreator");
        
        DataSourceConfig dbConfig = new DataSourceConfig(dataSourceNames);

        DataSource myConnection = DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .driverClassName(com.sap.db.jdbc.Driver.class.getName())   
            .url(hostname)
            .username(username)
            .password(password)
            .build();

        try {
            myConnection.getConnection().setSchema(schemaname);
        } catch (SQLException e){
            e.printStackTrace();
        }

        cloudFoundryDataSourceConfigLogger.info("Detected Host Name is :" + this.hostname);
        cloudFoundryDataSourceConfigLogger.info("Detected Post Name is :" + this.port);
        cloudFoundryDataSourceConfigLogger.info("Detected Schema Name is :" + this.schemaname);
        cloudFoundryDataSourceConfigLogger.info("Detected User Name is :" + this.username);

        return myConnection;
    }
} 
