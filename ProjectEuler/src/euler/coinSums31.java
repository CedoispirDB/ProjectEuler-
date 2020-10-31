package euler;

public class coinSums31 {
    // 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
    // 200p
    // a + 2b + 5c + 10w + 20x + 50y + 100z = 200

    private static int sumCoins(int p1, int p2, int p5, int p10, int p20, int p50, int p100) {
        int a = 1;
        int b = 2;
        int c = 5;
        int w = 10;
        int x = 20;
        int y = 50;
        int z = 100;
        return a * p1 + b * p2 + c * p5 + w * p10 + x * p20 + y * p50 + z * p100;
    }

    private static int comNum() {
        int ways = 1;

        for (int p100 = 0; p100 <= 2; p100++) {
            for (int p50 = 0; p50 <= 4; p50++) {
                for (int p20 = 0; p20 <= 10; p20++) {
                    for (int p10 = 0; p10 <= 20; p10++) {
                        for (int p5 = 0; p5 <= 40; p5++) {
                            for (int p2 = 0; p2 <= 100; p2++) {
                                for (int p1 = 0; p1 <= 200; p1++) {
                                    if (sumCoins(p1, p2, p5, p10, p20, p50, p100) == 200) {
                                        ways++;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        tools.d(comNum());
    }
}
