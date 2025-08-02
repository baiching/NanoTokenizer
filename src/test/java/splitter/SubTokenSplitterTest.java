package splitter;

import com.baiching.splitter.SubTokenSplitter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTokenSplitterTest {
    private final SubTokenSplitter splitter = new SubTokenSplitter();

    @Test
    void split_shouldHandleStandardFilenames() {
        String input = "document-v1.2.3_final.pdf";
        List<String> expected = List.of("document", "v1", "2", "3", "final", "pdf");

        List<String> result = splitter.split(input);

        assertEquals(expected, result);
    }

    @Test
    void split_shouldHandleWindowsPaths() {
        String input = "C:\\Users\\john_doe\\my-file_v2.exe";
        List<String> expected = List.of("C:", "Users", "john", "doe", "my", "file", "v2", "exe");

        List<String> result = splitter.split(input);

        assertEquals(expected, result);
    }

    @Test
    void split_shouldHandleUnixPaths() {
        String input = "/home/user.name/docs_2023/report-final.pdf";
        List<String> expected = List.of("", "home", "user", "name", "docs", "2023", "report", "final", "pdf");

        List<String> result = splitter.split(input);

        assertEquals(expected, result);
    }

    @Test
    void split_shouldHandleComplexFilenames() {
        String input = "node_modules/@angular/core-12.3.1_esm.js";
        List<String> expected = List.of("node", "modules", "@angular", "core", "12", "3", "1", "esm", "js");

        List<String> result = splitter.split(input);

        assertEquals(expected, result);
    }
}
