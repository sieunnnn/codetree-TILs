import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(answer);
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0; // 초기화
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + j;
                    int ny = dy[k] + i;

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (map[ny][nx] == 1) {
                            cnt++;
                        }
                    }
                }
                if (cnt >= 3) {
                    answer++;
                }
            }
        }
    }
}