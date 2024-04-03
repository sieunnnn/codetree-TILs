import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int t;
    static int[][] belts;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        belts = new int[3][n];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                belts[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i++) {
            move();
        }

        print();
    }

    public static void move() {
        int lastNumber = belts[2][n - 1];

        for (int i = 0; i < 3; i++) {
            int currentLastNumber = belts[i][n - 1];

            for (int j = n - 1; j > 0; j--) {
                int temp = belts[i][j - 1];
                belts[i][j] = temp;
            }
            
            belts[i][0] = lastNumber;
            lastNumber = currentLastNumber;
        }
    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(belts[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}