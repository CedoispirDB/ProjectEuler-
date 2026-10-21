package utils;


public class LinkedTest {

    public static void main(String[] args) {
        // testSearch();
        // testGet();
        // testResetCurrent();
        testLoop();
    }

    private static void testSearch() {
   Linked<Integer> list = new Linked<>();

        Tools.check(!list.search_from_current(10), "Search in empty list");

        list.link_last(2);
        list.link_last(5);
        list.link_last(9);
        list.link_last(14);
        list.link_last(20);
        list.link_last(31);
        list.link_last(45);

        Tools.check(list.search_from_current(2), "Search first element");
        Tools.check(list.search_from_current(14), "Search middle element");
        Tools.check(list.search_from_current(45), "Search last element");

        list.reset_current();

        Tools.check(!list.search_from_current(10), "Search missing element between nodes");
        Tools.check(!list.search_from_current(1), "Search below first element");

        list.reset_current();

        Tools.check(!list.search_from_current(50), "Search above last element");
    }

    private static void testGet() {
        Linked<Integer> list = new Linked<>();

        Tools.check_null(list.get(0), "Get from empty list");

        list.link_last(2);
        list.link_last(5);
        list.link_last(9);
        list.link_last(14);
        list.link_last(20);

        Tools.check(list.get(0) == 2, "Get first element");
        Tools.check(list.get(2) == 9, "Get middle element");
        Tools.check(list.get(4) == 20, "Get last element");

        Tools.check_null(list.get(-1), "Get negative index");
        Tools.check_null(list.get(5), "Get index equal to size");
        Tools.check_null(list.get(100), "Get index above size");
    }

    private static void testResetCurrent() {
         Linked<Integer> list = new Linked<>();

        list.link_last(2);
        list.link_last(5);
        list.link_last(9);
        list.link_last(14);
        list.link_last(20);

        Tools.check(list.search_from_current(9), "Find element before reset");

        list.reset_current();

        Tools.check(list.search_from_current(2), "Search from beginning after reset");
        Tools.check(list.search_from_current(14), "Continue search after reset");

        list.reset_current();

        Tools.check(list.search_from_current(5), "Reset current more than once");
    }

    private static void testLoop() {
        Linked<Integer> list = new Linked<>();
        for(int i = 0; i < Const.ONE_MILLION; i++) {
            list.link_last(i);
        }

        for (int i = 0; i < Const.ONE_MILLION; i++) {
            if(i % 2 == 0) {
                if(list.search_from_current(i));
            }
        }
    }
}
