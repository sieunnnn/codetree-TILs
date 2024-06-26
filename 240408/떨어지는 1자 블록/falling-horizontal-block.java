import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int startY;
    static List<Integer> rows = new ArrayList<>();

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

        // System.out.println("입력: " + Arrays.deepToString(map));
        findStartLine();
        solve();
        print();
    }

    public static void findStartLine() {
        for (int x = k; x < k + m; x++) {
            for (int y = 0; y < n; y++) {
                if (!isAllBlanked(y)) {
                    // System.out.println("y: " + y);
                    startY = y - 1;
                    // System.out.println("startY: " + startY);
                    break;

                } else if (y == n - 1) {
                    startY = y;
                    break;
                }
            }
        }
    }

    public static boolean isAllBlanked(int currentY) {
        for (int i = k; i < k + m; i++) {
            if (map[currentY][i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void solve() {
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