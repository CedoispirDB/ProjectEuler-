package utils;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Array;

public class Log {

    public static boolean LOGGING = true;

    public static void print(Object x) {
        if (!LOGGING) {
            return;
        }
        System.out.print(x);
    }

    public static void println(Object x) {
        print(x + "\n");
    }

    public static void printf(String format, Object... args) {
        if (!LOGGING) {
            return;
        }
        System.out.printf(format, args);
    }

    public static void printfln(String format, Object... args) {
        printf(format + "\n", args);
    }

    public static void skip_line() {
        println("");
    }

    public static void all(Object... args) {
        if (!LOGGING) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            if (i != args.length - 1) {
                print(args[i] + ", ");
            } else {
                println(args[i]);
            }
        }
    }

    // TODO: handle if value is list or map
    public static void map(Map<?, ?> map) {
        if (!LOGGING) {
            return;
        }
        if (map.isEmpty()) {
            println("Map is empty");
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            printfln("key: %s, value: %s", entry.getKey(), entry.getValue());
        }
    }

    public static void list(List<?> list) {
        if (!LOGGING) {
            return;
        }

        if (list.isEmpty()) {
            println("List is empty");
        }

        for (int i = 0; i < list.size(); i++) {
            printfln("%d) %s", i + 1, list.get(i));
        }
    }

    public static void listSep(List<?> list, String sep) {
        if (!LOGGING) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                print(list.get(i) + sep);
            } else {
                print(list.get(i));
            }
        }
        skip_line();
    }

    public static void listToStr(List<?> list) {
        listSep(list, "");
    }

    public static void listToRow(List<?> list) {
        listSep(list, ", ");
    }

    public static void array(Object array) {
        if (!LOGGING) {
            return;
        }

        if (array == null || !array.getClass().isArray()) {
            throw new IllegalArgumentException("Expected an array");
        }

        for (int i = 0; i < Array.getLength(array); i++) {
            printfln("%d) %s", i + 1, Array.get(array, i));
        }
    }
}
