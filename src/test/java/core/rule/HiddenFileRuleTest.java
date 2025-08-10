package core.rule;

import com.baiching.rule.HiddenFileRule;
import com.baiching.rule.TokenRule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HiddenFileRuleTest {
    TokenRule rules = new HiddenFileRule();
    @Test
    public void testFileWithHiddenAttribute() throws IOException {
        Path file = Files.createTempFile("winhidden", ".tmp");
        Files.setAttribute(file, "dos:hidden", true);  // Windows hidden flag

        assertTrue(rules.matches(file.toString()));
        Files.deleteIfExists(file);
    }

    @Test
    public void testNormalVisibleFile() throws IOException {
        Path file = Files.createTempFile("visible", ".txt");

        assertFalse(rules.matches(file.toString()));
        Files.deleteIfExists(file);
    }

    // --- Windows Special Cases ---
    @Test
    public void testSystemHiddenFile() {
        // Typical Windows system file (hidden by default)
        assertTrue(rules.matches("C:\\Windows\\System32\\drivers\\etc\\hosts"));
    }

    @Test
    public void testDotPrefixedFileNotHidden() throws IOException {
        // Unix-style dotfile - should NOT be hidden on Windows
        Path dotFile = Files.createTempFile(".notHidden", ".tmp");

        assertFalse(rules.matches(dotFile.toString()));  // Different from Unix!
        Files.deleteIfExists(dotFile);
    }

    // --- Edge Cases ---
    @Test
    public void testHiddenDirectory() throws IOException {
        Path dir = Files.createTempDirectory("hiddenDir");
        Files.setAttribute(dir, "dos:hidden", true);

        assertTrue(rules.matches(dir.toString()));
        Files.deleteIfExists(dir);
    }

    @Test
    public void testNonExistentPath() {
        assertFalse(rules.matches("Z:\\nonexistent\\fakefile.txt"));
    }

    // --- Network/UNC Paths ---
    @Test
    public void testHiddenNetworkShare() {
        // Windows hidden shares end with $
        assertTrue(rules.matches("\\\\server\\secret$\\file.txt"));
    }
}
