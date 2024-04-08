import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int k;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        print();
    }

    public static void solve() {
        int startY = n;
        for (int i = k; i < k + m; i++) {
            for (int y = 0; y < n; y++) {
                if (map[y][i] == 1) {
                    startY = Math.min(startY, y - 1);
                    break;
                }

                if (y == n - 1) {
                    startY = n - 1;
                }
            }
        }

        for (int i = k; i < k + m; i++) {
            map[startY][i] = 1;
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}