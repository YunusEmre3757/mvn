package mygroup;

/**
 * Service class provided by the mygroup starter.
 */
public class MygroupService {
    
    private final String greeting;
    
    public MygroupService(String greeting) {
        this.greeting = greeting;
    }
    
    /**
     * Print a greeting message.
     */
    public void sayGreeting() {
        System.out.println(greeting);
    }
    
    /**
     * Get the configured greeting message.
     *
     * @return the greeting message
     */
    public String getGreeting() {
        return greeting;
    }
} 