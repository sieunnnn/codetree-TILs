import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] graph;
    static int[][][] blocks = {
        // L 모양
        {{0, 0}, {1, 0}, {1, 1}},
        {{0, 0}, {0, 1}, {1, 0}},
        {{0, 0}, {-1, 0}, {-1, 1}},
        {{0, 0}, {0, -1}, {1, 0}},
        {{0, 0}, {1, 0}, {1, -1}},
        {{0, 0}, {0, 1}, {-1, 0}},
        {{0, 0}, {-1, 0}, {-1, -1}},
        {{0, 0}, {0, -1}, {-1, 0}},
        
        // 직선모양
        {{0, 0}, {0, 1}, {0, 2}},
        {{0, 0}, {1, 0}, {2, 0}},
        {{0, 0}, {0, -1}, {0, -2}},
        {{0, 0}, {-1, 0}, {-2, 0}}
    };
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(answer);
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findMaxValue(i, j);
            }
        }
    }

    public static void findMaxValue(int y, int x) {
        for (int k = 0; k < blocks.length; k++) {
            int sum = 0;
            for (int s = 0; s < 3; s++) {
                int newY = y + blocks[k][s][0];
                int newX = x + blocks[k][s][1];

                if (newY >= 0 && newY < n && newX >= 0 && newX < m) {
                    sum += graph[newY][newX];
                } else {
                    sum = 0;
                    break;
                }
            }
            answer = Math.max(answer, sum);
        }
    }
}