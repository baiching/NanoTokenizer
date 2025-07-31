package core;

import com.baiching.core.FilePathTokenizer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathTokenizerTest {
    FilePathTokenizer filePathTokenizer = new FilePathTokenizer();
    @Test
    public void testBasicWindowsPath() {
        List<String> expected = Arrays.asList("C:", "Program Files", "Java");
        assertEquals(expected, filePathTokenizer.tokenize("C:\\Program Files\\Java"));
    }

    @Test
    public void testWindowsPathWithForwardSlashes() {
        List<String> expected = Arrays.asList("D:", "Projects", "src");
        assertEquals(expected, filePathTokenizer.tokenize("D:/Projects/src"));
    }

    @Test
    public void testWindowsAbsolutePath() {
        List<String> expected = Arrays.asList("", "C:", "Windows", "System32");
        assertEquals(expected, filePathTokenizer.tokenize("\\C:\\Windows\\System32"));
    }

    @Test
    public void testWindowsDriveRoot() {
        List<String> expected = Arrays.asList("C:", "");
        assertEquals(expected, filePathTokenizer.tokenize("C:\\"));
    }

    @Test
    public void testWindowsNetworkPath() {
        List<String> expected = Arrays.asList("", "Server", "Share", "Files");
        assertEquals(expected, filePathTokenizer.tokenize("\\\\Server\\Share\\Files"));
    }

    @Test
    public void testWindowsPathWithSpaces() {
        List<String> expected = Arrays.asList("C:", "My Documents", "Reports");
        assertEquals(expected, filePathTokenizer.tokenize("C:\\My Documents\\Reports"));
    }

    @Test
    public void testWindowsPathWithDots() {
        List<String> expected = Arrays.asList("D:", "Project", ".config", "..", "files");
        assertEquals(expected, filePathTokenizer.tokenize("D:\\Project\\.config\\..\\files"));
    }

    @Test
    public void testWindowsPathMixedSlashes() {
        List<String> expected = Arrays.asList("E:", "Data", "Backup");
        assertEquals(expected, filePathTokenizer.tokenize("E:\\Data/Backup"));
    }

    @Test
    public void testWindowsCurrentDirectory() {
        List<String> expected = Arrays.asList(".", "src", "main");
        assertEquals(expected, filePathTokenizer.tokenize(".\\src\\main"));
    }

    @Test
    public void testWindowsParentDirectory() {
        List<String> expected = Arrays.asList("..", "config", "settings");
        assertEquals(expected, filePathTokenizer.tokenize("..\\config\\settings"));
    }

    @Test
    public void testWindowsMultipleBackslashes() {
        List<String> expected = Arrays.asList("C:", "", "Temp", "");
        assertEquals(expected, filePathTokenizer.tokenize("C:\\\\Temp\\"));
    }

    @Test
    public void testWindowsPathEndingWithBackslash() {
        List<String> expected = Arrays.asList("D:", "Downloads", "");
        assertEquals(expected, filePathTokenizer.tokenize("D:\\Downloads\\"));
    }

}
