import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> map = new HashMap<>();
    static String[] equation;
    static String[] alphabets;

    static int[] numbers = {1, 2, 3, 4};
    static int max = Integer.MIN_VALUE;
    static int count;

    public static void main(String[] args) throws IOException {
        equation = br.readLine().split("");

        int length = equation.length / 2 + 1;

        alphabets = new String[length];

        for (int i = 0; i < equation.length; i++) {
            if (i % 2 == 0) { // 짝수 -> 알파벳
                String alphabet = equation[i];
                map.put(alphabet, 0);
            }
        }

        count = map.size();
        // System.out.println(count);
        mapInit();
        solve(0, 0);

        System.out.println(max);
    }

    public static void mapInit() {
        int id = 0;

        for (String key : map.keySet()) {
            alphabets[id++] = key;
        }
    }

    public static void solve(int start, int depth) {
        if (depth == count) {
            int result = calculate();
            max = Math.max(result, max);

            // for (String key: map.keySet()) {
            //     System.out.print(map.get(key) + " ");
            // }

            // System.out.println(result);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            map.put(alphabets[depth], numbers[i]);
            // System.out.print(alphabets[depth] + " " + numbers[i] + " ");
            solve(0, depth + 1); 
        }
        // System.out.println("\n");
    }

    public static int calculate() {
        int result = map.get(equation[0]);

        for (int i = 1; i < equation.length; i += 2) {
            if (equation[i].equals("+")) {
                result += map.get(equation[i + 1]);

            } else if (equation[i].equals("-")) {
                result -= map.get(equation[i + 1]);

            } else if (equation[i].equals("*")){
                result *= map.get(equation[i + 1]);
            }
        }

        return result;
    }
}