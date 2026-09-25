import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Autograder tests for HelloWorld.java.
 * You do not need to edit this file. Run with:  mvn test
 */
class HelloWorldTest {

    @Test
    @DisplayName("HelloWorld prints exactly 'Hello, World!'")
    void printsHelloWorld() {
        String output = OutputCapture.run(() -> HelloWorld.main(new String[0]));
        assertEquals("Hello, World!", output.strip(),
                "Check spelling, capitalization, the comma, and the exclamation point.");
    }
}
