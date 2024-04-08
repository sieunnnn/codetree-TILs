import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, r, c;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(r, c);

        for (int num : path) {
            System.out.print(num + " ");
        }
    }

    public static void solve(int y, int x) {
        path.add(map[y][x]);

        while (true) {
            int currentVal = map[y][x];
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && map[ny][nx] > currentVal) { // 사방 검사하고 제일 큰 경우만 움직이기
                    y = ny;
                    x = nx;
                    path.add(map[y][x]);
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                break;
            }
        }
    }
}