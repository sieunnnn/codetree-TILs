import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] rectangles = new int[1001];
    static int n;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        makeRectangles();
        System.out.println(rectangles[n]);
    }

    public static void makeRectangles() {
        rectangles[2] = 3;
        rectangles[3] = 5;
        
        for (int i = 4; i < 1001; i++) {
            rectangles[i] = (rectangles[i - 1] + 2 * (rectangles[i - 2])) % MOD;
        }
    }
}