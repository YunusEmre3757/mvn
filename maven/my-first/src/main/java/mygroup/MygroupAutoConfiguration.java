package mygroup;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for mygroup starter.
 */
@Configuration
@EnableConfigurationProperties(MygroupProperties.class)
@ConditionalOnProperty(prefix = "mygroup", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MygroupAutoConfiguration {

    private final MygroupProperties properties;

    public MygroupAutoConfiguration(MygroupProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public MygroupService mygroupService() {
        return new MygroupService(properties.getGreeting());
    }
} 