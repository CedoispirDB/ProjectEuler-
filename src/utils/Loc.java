package utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class Loc {

    public static Path getDesktopPath() {
        Path path = Path.of(System.getProperty("user.home"), "Desktop");
        return path;
    }

    public static Path getDesktopFile(String file_name) {
        return Path.of(System.getProperty("user.home"), "Desktop", file_name);
    }

    public static Path getDataPath(String file_name) {
        return Path.of("data", file_name);
    }

    public static List<String> getFileLines(String file_name) {
        try {
            return Files.readAllLines(getDataPath(file_name));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
