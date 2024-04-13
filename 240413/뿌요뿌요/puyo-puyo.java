import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] graph;
    static boolean visited[][];
    static int cnt;
    static int blocksize;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                blocksize = 0;
                solve(j, i, graph[i][j]);
                
                if(blocksize >= 4) {
                    cnt++;
                    max = Math.max(max, blocksize);
                }
            }
        }

        System.out.println(cnt + " " + max);
    }

    public static void solve(int x, int y, int target) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[ny][nx] && graph[ny][nx] == target) {
                    visited[ny][nx] = true;
                    blocksize++;
                    solve(nx, ny, target);
                }
            }
        }
    }
}