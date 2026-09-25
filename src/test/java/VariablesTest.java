import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Autograder tests for Variables.java.
 * You do not need to edit this file. Run with:  mvn test
 */
class VariablesTest {

    private static final Path SOURCE = Path.of("src", "main", "java", "Variables.java");

    private static String[] outputLines() {
        String output = OutputCapture.run(() -> Variables.main(new String[0]));
        return output.strip().split("\n");
    }

    /** The student's code with all comments removed, so the instructions don't count. */
    private static String codeWithoutComments() throws IOException {
        String source = Files.readString(SOURCE);
        return source
                .replaceAll("(?s)/\\*.*?\\*/", "")   // block comments
                .replaceAll("//[^\\n]*", "");        // line comments
    }

    private static void assertDeclares(String code, String type, String name) {
        Pattern declaration = Pattern.compile("\\b" + type + "\\s+" + name + "\\s*=");
        assertTrue(declaration.matcher(code).find(),
                "Expected a variable declared as: " + type + " " + name + " = ...");
    }

    @Test
    @DisplayName("Prints exactly five lines")
    void printsFiveLines() {
        String[] lines = outputLines();
        assertEquals(5, lines.length,
                "Your program should print exactly 5 lines. It printed " + lines.length + ".");
    }

    @Test
    @DisplayName("Line 1: Course: CS 142")
    void printsCourse() {
        String[] lines = outputLines();
        assertEquals("Course: CS 142", lines[0].strip());
    }

    @Test
    @DisplayName("Line 2: Credits: 5")
    void printsCredits() {
        String[] lines = outputLines();
        assertTrue(lines.length >= 2, "Missing line 2.");
        assertEquals("Credits: 5", lines[1].strip());
    }

    @Test
    @DisplayName("Line 3: Meal cost: 40.0")
    void printsMealCost() {
        String[] lines = outputLines();
        assertTrue(lines.length >= 3, "Missing line 3.");
        assertEquals("Meal cost: 40.0", lines[2].strip());
    }

    @Test
    @DisplayName("Line 4: Tip: 8.0")
    void printsTip() {
        String[] lines = outputLines();
        assertTrue(lines.length >= 4, "Missing line 4.");
        assertEquals("Tip: 8.0", lines[3].strip());
    }

    @Test
    @DisplayName("Line 5: Total: 48.0")
    void printsTotal() {
        String[] lines = outputLines();
        assertTrue(lines.length >= 5, "Missing line 5.");
        assertEquals("Total: 48.0", lines[4].strip());
    }

    @Test
    @DisplayName("Uses variables with the right types")
    void declaresVariables() throws IOException {
        String code = codeWithoutComments();
        assertDeclares(code, "String", "courseName");
        assertDeclares(code, "int", "credits");
        assertDeclares(code, "double", "mealCost");
        assertDeclares(code, "int", "tipPercent");
    }

    @Test
    @DisplayName("Calculates the tip and total instead of typing the answers")
    void doesNotHardCodeAnswers() throws IOException {
        String code = codeWithoutComments();
        assertFalse(code.contains("8.0") || Pattern.compile("\\b48\\b").matcher(code).find(),
                "Calculate the tip and total with arithmetic instead of typing 8.0 or 48.0.");
        assertTrue(code.contains("*"), "The tip should be calculated using multiplication (*).");
    }
}
