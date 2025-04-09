package mygroup;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mygroup")
public class MygroupProperties {
    
    /**
     * Enable mygroup features. Default is true.
     */
    private boolean enabled = true;
    
    /**
     * The greeting message to use. Default is "Hello from mygroup starter!"
     */
    private String greeting = "Hello from mygroup starter!";
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
} 