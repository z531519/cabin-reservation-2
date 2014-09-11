package com.blacklinuxdude.cabin;


import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.autoconfigure.jdbc.AbstractDataSourceConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.TomcatDataSourceConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ClearDBDataSourceConfiguration extends AbstractDataSourceConfiguration {
    @Conditional(ClearDBDataSourceConfiguration.ClearDBDatabaseCondition.class)
    @ConditionalOnMissingBean(DataSource.class)
    @Import(ClearDBDataSourceConfiguration.class)
    protected static class TomcatConfiguration {

    }

    static class ClearDBDatabaseCondition extends SpringBootCondition {

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
            String url = System.getenv("CLEARDB_DATABASE_URL");
            if (url != null) {
                if (url.contains("heroku")) {
                    return ConditionOutcome.match("ClearDB MySQL from Heroku loaded");
                }
            }
            return ConditionOutcome.noMatch("Non-Clear DB");
        }
    }

    private String jdbcInterceptors;
    private long validationInterval = 30000;
    private org.apache.tomcat.jdbc.pool.DataSource pool;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws URISyntaxException {
        this.pool = new org.apache.tomcat.jdbc.pool.DataSource();
        this.pool.setDriverClassName(getDriverClassName());

        URI dbUri = new URI(getUrl());
        if (dbUri.getUserInfo() != null) {
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
            this.pool.setUrl(dbUrl);
            this.pool.setUsername(username);
            this.pool.setPassword(password);
        } else {
            this.pool.setUrl(getUrl());
            if (getUsername() != null) {
                this.pool.setUsername(getUsername());
            }
            if (getPassword() != null) {
                this.pool.setPassword(getPassword());
            }
        }




        this.pool.setInitialSize(getInitialSize());
        this.pool.setMaxActive(getMaxActive());
        this.pool.setMaxIdle(getMaxIdle());
        this.pool.setMinIdle(getMinIdle());
        this.pool.setTestOnBorrow(isTestOnBorrow());
        this.pool.setTestOnReturn(isTestOnReturn());
        this.pool.setTestWhileIdle(isTestWhileIdle());
        if (getTimeBetweenEvictionRunsMillis() != null) {
            this.pool
                    .setTimeBetweenEvictionRunsMillis(getTimeBetweenEvictionRunsMillis());
        }
        if (getMinEvictableIdleTimeMillis() != null) {
            this.pool.setMinEvictableIdleTimeMillis(getMinEvictableIdleTimeMillis());
        }
        this.pool.setValidationQuery(getValidationQuery());
        this.pool.setValidationInterval(this.validationInterval);
        if (getMaxWaitMillis() != null) {
            this.pool.setMaxWait(getMaxWaitMillis());
        }
        if (this.jdbcInterceptors != null) {
            this.pool.setJdbcInterceptors(this.jdbcInterceptors);
        }
        return this.pool;
    }

    @PreDestroy
    public void close() {
        if (this.pool != null) {
            this.pool.close();
        }
    }

    public void setJdbcInterceptors(String jdbcInterceptors) {
        this.jdbcInterceptors = jdbcInterceptors;
    }

    public void setValidationInterval(long validationInterval) {
        this.validationInterval = validationInterval;
    }

}
