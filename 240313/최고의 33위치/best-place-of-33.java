import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int N;
    static int max = 0;
    static int coinNum;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(max);
    }

    public static void solve() {
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= N - 3; j++) {
                coinNum = 0;
                checkCoin(i, j);
            }
        }
    }

    public static void checkCoin(int x, int y) {
        for (int i = y; i < y + 3; i ++) {
            for (int j = x; j < x + 3; j ++) {
                if (graph[i][j] == 1) {
                    coinNum ++;
                }
            }
        }

        max = Math.max(max, coinNum);
    }
}