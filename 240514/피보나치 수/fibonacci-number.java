import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] fibonacci = new int[46];
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        makeFibonacci();
        System.out.println(fibonacci[N]);
    }

    public static void makeFibonacci() {
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        for (int i = 3; i < 46; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }
}