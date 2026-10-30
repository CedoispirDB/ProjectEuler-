package euler;

import java.lang.reflect.Array;
import java.util.*;
import utils.*;

public class a60PrimePairSets {

    static HashMap<Integer, LinkedList<Integer>> candidates = new HashMap<>();
    static LinkedList<Integer> final_candidates = new LinkedList<>();

    static ArrayList<Integer> bound_primes = new ArrayList<>(List.of(1, 3, 7, 9));

    private static void clean_candidates(int target) {
        var iterator = ListT.getMapIterator(candidates);

        boolean first_key = true;

        while (iterator.hasNext()) {
            var entry = iterator.next();

            LinkedList<Integer> v = entry.getValue();

            if (v.size() < target) {
                iterator.remove();
                continue;
            }

            Iterator<Integer> iv = v.iterator();

            while (iv.hasNext()) {
                int c = iv.next();

                if (first_key) {
                    final_candidates.add(c);
                    continue;
                }

                if (final_candidates.contains(c)) {
                    // keep c there
                }
            }

            first_key = false;
        }

        final_candidates.sort(null);
    }

    private static void parse_prime(int k) {
        int mod = 10;
        int back;
        int front = -1;

        while (front != 0) {
            add:
            {
                front = k / mod;
                back = k % mod;

                // Log.all(front, back, mod);
                if (!(PrimeT.isPrime(front) && PrimeT.isPrime(back))) {
                    break add;
                }

                Integer r = Integer.valueOf(String.valueOf(back) + String.valueOf(front));
                if (!PrimeT.isPrime(r)) {
                    break add;
                }

                int key;
                int value;
                if (front < back) {
                    key = front;
                    value = back;
                } else {
                    key = back;
                    value = front;
                }

                LinkedList<Integer> v1 = candidates.get(key);
                LinkedList<Integer> v2 = candidates.get(value);

                if (v1 == null) {
                    LinkedList<Integer> n = new LinkedList<>(List.of(value));
                    n.add(key);
                    candidates.put(key, n);
                } else {
                    if (!v1.contains(value)) {
                        v1.add(value);
                    }
                }

                if (v2 == null) {
                    LinkedList<Integer> n = new LinkedList<>(List.of(key));
                    n.add(value);
                    candidates.put(value, n);
                } else {
                    if (!v2.contains(key)) {
                        v2.add(key);
                    }
                }
            }

            mod *= 10;

        }

    }

    private static void process() {
        int k = 6733;

        while (true) {
            if (PrimeT.isPrime(k)) {
                parse_prime(k);
            }

            k += 2;

            if (k > 70000) {
                break;
            }

        }

        // clean_candidates(4);
        Log.map(candidates);
        Log.list(final_candidates);
    }

    public static void test_0() {
        // Log.println(PrimeT.prime(5));
        // Log.println(PrimeT.isPrime(10911));
        // process();
        // int p1 = PrimeT.prime(1);
        // int p2 = P1rimeT.prime(2);
        // search(p1, 2);
        // search(p2, 3);        
        // int x = 1093;
        // Log.all(x % 10, x % 100, x % 1000);
        // Log.all(x / 10, x / 100 x / 1000);
        HashMap<Integer, LinkedList<Integer>> sum = new HashMap<>();

        int valid = 0;
        int invalid = 0;
        for (int i = 1; i <= Const.ONE_MILLION; i++) {
            int p = PrimeT.prime(i);
            int digit_count = Str.digitCount(p) - 1;
            int k = p / (int) Math.pow(10, (double) digit_count);
            // Log.all(i, p, k, (int) Math.pow(10, (double) p));;
            int ds = Mat.digitsSum(p);

            if (bound_primes.contains(k)) {
                LinkedList<Integer> v = sum.get(ds);
                if (v == null) {
                    sum.put(ds, new LinkedList<>(List.of(p)));
                } else {
                    v.add(p);
                }

            }

            if (ds % 3 != 0 && ds % 9 != 0 && bound_primes.contains(k)) {
                // Log.printfln("%d) %d", i, p);
                valid++;
            } else {
                invalid++;
            }
            // Log.println("digit sum: " + Mat.digitsSum(p));
        }

        Log.all(valid, invalid, valid - invalid);
        Log.map(sum);

        LinkedList<Tuple<Integer, Integer>> pairs = new LinkedList<>();
        LinkedList<Integer> found = new LinkedList<>();

        for (Map.Entry<Integer, LinkedList<Integer>> e : sum.entrySet()) {
            LinkedList<Integer> v = e.getValue();
            Log.println("Size: " + v.size());

            if (v.size() < 2) {
                continue;
            }

            for (int i = 0; i < v.size(); i++) {
                int current = v.get(i);
                if (found.contains(current)) {
                    continue;
                }

                for (int j = 0; j < v.size(); j++) {
                    int test = v.get(j);
                    String t_str = String.valueOf(test);
                    int reversed = Integer.parseInt(t_str.charAt(t_str.length() - 1) + t_str.substring(0, t_str.length() - 1));
                    if (current == reversed) {
                        pairs.add(new Tuple<>(current, test));
                        found.add(current);
                        found.add(test);
                        break;
                    }
                }
            }
        }

        Log.list(pairs);

    }

    public static boolean valid_prime(int p) {
        int digit_count = Str.digitCount(p) - 1;
        int k = p / (int) Math.pow(10, (double) digit_count);
        return bound_primes.contains(k);
    }

    public static void test_1(int target) {
        int outer = 30_000; // start at p0 = 3
        int inner = 1; // start at p2 = 3;
        int p0;
        int p1;
        boolean found = false;

        var primes = PrimeT.savedPrimes();

        HashMap<Integer, LinkedList<Integer>> visited = new HashMap<>();

        while (true) {
            p0 = PrimeT.prime(outer);
            String p0_str = String.valueOf(p0);
            int ds0 = Mat.digitsSum(p0_str);

            var v = visited.get(p0);
            if (v == null) {
                v = new LinkedList<>();
                visited.put(p0, v);
            }

            // Log.println("p0: " + p0);
            // test combinations prio to p0
            while (true) {
                p1 = primes.get(inner);
                // Log.println("p1: " + p1);
                if (p1 >= p0) {
                    break;
                }

                if (p1 == 5) {
                    inner++;
                    continue;
                }

                String p1_str = String.valueOf(p1);
                int ds1 = Mat.digitsSum(p1_str);
  
                int dst = ds0 + ds1;

                if (dst % 3 == 0 || dst % 9 == 0) {
                    inner++;
                    continue;
                }

                String test_str_1 = p0_str + p1_str;
                String test_str_2 = p1_str + p0_str;
                int test_1 = Integer.parseInt(test_str_1);
                int test_2 = Integer.parseInt(test_str_2);

                if (PrimeT.arePrime(test_1, test_2)) {
                    v.add(p1);
                    var c1 = visited.get(test_1);
                    if (c1 == null) {
                        c1 = new LinkedList<>();
                    }
                    c1.add(p0);
                    c1.add(p1);
                    var c2 = visited.get(test_2);
                    if (c2 == null) {
                        c2 = new LinkedList<>();
                    }
                    c2.add(p0);
                    c2.add(p1);

                    var v1 = visited.get(p1);
                    if (v1 == null) {
                        v1 = new LinkedList<>();
                    }
                    v1.add(p0);

                    if (v.size() == target - 1) {
                        found = true;
                        break;
                    }
                }

                inner++;
            }

            if (found) {
                // test candidate
                Log.println("Trying: " + p0 + ": " + v);
                // Log.map(visited);
                for (int i = 0; i < v.size(); i++) {
                    int t0 = v.get(i);
                    for (int j = i; j < v.size(); j++) {
                        int t1 = v.get(j);

                        if (t0 == t1) {
                            continue;
                        }

                        boolean check = !visited.get(t0).contains(t1);

                        // Log.println("t0: " + t0 + " t1 : " + t1 + ", check: " + check);
                        if (check) {
                            found = false;
                            break;
                        }

                    }

                    if (!found) {
                        break;
                    }
                }


                if (found) {
                    break;
                }

            }

            outer++;
            inner = 1;
        }

        Log.map(visited);
        Log.println(p0 + ": " + visited.get(p0));
        var end = visited.get(p0);
        int r = p0;
        for (int i = 0; i < end.size(); i++) {
            r += end.get(i);
        }

        Log.println("Solution: " + r);

    }

    public static void main(String[] args) {
        test_1(5);
        int c1 = 977;
        int c2 = 797;
        int c3 = 9719;
        int c4 = 1997;
        int c5 = 9743;
        int c6 = 4397;
        int c7 = 719;
        int c8 = 197;
        int c9 = 743;

        int c10 = 437;
        int c11 = 1943;
        int c12 = 4319;

        Log.println(PrimeT.arePrime(437, 743));

        // Log.println(PrimeT.isPrime(c1));
        // Log.println(PrimeT.isPrime(c2));
        // Log.println(PrimeT.isPrime(c3));
        // Log.println(PrimeT.isPrime(c4));
        // Log.println(PrimeT.isPrime(c5));
        // Log.println(PrimeT.isPrime(c6));
        // Log.println(PrimeT.isPrime(c7));
        // Log.println(PrimeT.isPrime(c8));
        // Log.println(PrimeT.isPrime(c9));
        // Log.println(PrimeT.isPrime(c10));
        // Log.println(PrimeT.isPrime(c11));
        // Log.println(PrimeT.isPrime(c12));
    }
}
