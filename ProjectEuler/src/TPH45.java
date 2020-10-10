public class TPH45 {
    public static void TPHSameResults() {
        long triangle;
        long pentagon;
        long hexagon;
        int t = 287;
        int p = 166;
        int h = 144;
        int count = 0;
        do {
            triangle = t * (t + 1) / 2;
            pentagon = p * (3 * p - 1) / 2;
            hexagon = h * (2 * h - 1);
            tools.d(triangle);
            tools.d(pentagon);
            tools.d(hexagon);
            if (triangle == hexagon && hexagon == pentagon) {
                tools.d(triangle);
                tools.d(pentagon);
                tools.d(hexagon);
                break;
            }
            t++;
            p++;
            h++;
            count++;
            if (count < 100) {
                t = t + 2;
                p = p + 2;
                h = h + 2;
            }
        } while (true);
    }

    public static void main(String[] args) {
        TPHSameResults();
    }
}
