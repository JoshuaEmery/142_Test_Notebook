import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Test helper: runs a piece of code and returns everything it printed to System.out. */
final class OutputCapture {

    private OutputCapture() {
    }

    static String run(Runnable code) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream capture = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            code.run();
        } finally {
            System.setOut(original);
        }
        // Normalize Windows line endings so tests behave the same everywhere.
        return buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }
}
