package com.blacklinuxdude.cabin;


import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.autoconfigure.jdbc.AbstractDataSourceConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ClearDBDataSourceAutoConfiguration implements EnvironmentAware {
    @Conditional(ClearDBDataSourceAutoConfiguration.ClearDBDatabaseCondition.class)
    @ConditionalOnMissingBean(DataSource.class)
    @Import(ClearDBDataSourceConfiguration.class)
    protected static class ClearDBDataSourceConfigurationDefinition {

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("Environment is :" + environment);
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

}
