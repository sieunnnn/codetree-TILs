import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] fibonacci = new int[46];
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);

        } else {
            makeFibonacci();
            System.out.println(fibonacci[N]);
        }
    }

    public static void makeFibonacci() {
        fibonacci[2] = 1;
        fibonacci[3] = 1;

        for (int i = 4; i < 46; i++) {
            fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 3]) % 10007;
        }
    }
}