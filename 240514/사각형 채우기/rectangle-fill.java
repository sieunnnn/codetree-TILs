import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] rectangles = new int[1001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        makeRectangles();
        System.out.println(rectangles[n]);
    }

    public static void makeRectangles() {
        rectangles[1] = 1;
        rectangles[2] = 2;
        rectangles[3] = 3;

        for (int i = 4; i < 1001; i++) {
            rectangles[i] = (rectangles[i - 1] + rectangles[i - 2]) % 10007;
        }
    }
}