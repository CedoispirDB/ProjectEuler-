package utils;

import java.nio.file.*;

public class Loc {

    public static Path getDesktopPath() {
        Path path = Path.of(System.getProperty("user.home"), "Desktop");
        return path;
    }

    public static Path getDesktopFile(String name) {
        return Path.of(System.getProperty("user.home"), "Desktop", name);
    }

}