package utils;

import java.util.Map;
import java.util.Iterator;

public class ListT {

    public static <K, V> Iterator<Map.Entry<K, V>> getMapIterator(Map<K, V> map) {
        return map.entrySet().iterator();
    }
}
