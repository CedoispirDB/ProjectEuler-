package utils;

import java.util.List;
import java.util.Map;

public class Log {

    public static void print(Object x) {
        System.out.print(x);
    }

    public static void println(Object x) {
        print(x + "\n");
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printfln(String format, Object... args) {
        printf(format + "\n", args);
    }

    public static void skip_line() {
        println("");
    }

    public static void map(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            printfln("key: %s, value: %s", entry.getKey(), entry.getValue());
        }
    }

    public static void list(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            printfln("%d) %s", i + 1, list.get(i));
        }
    }

    public static void listToStr(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            print(list.get(i));
        }
        skip_line();
    }
}
