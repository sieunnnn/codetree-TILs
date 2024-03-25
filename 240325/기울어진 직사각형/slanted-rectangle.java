import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int width = 1; width < n; width++) {
                    for (int height = 1; height < n; height++) {
                        if (width != height) {
                            solve(i, j, width, height);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void solve(int x, int y, int width, int height) {
        if (!isInBounds(x, y)) {
            return;
        }

        int sum = graph[y][x];

        for (int i = 1; i < width; i++) {
            x++;
            y++;
            if (!isInBounds(x, y)) return;
            sum += graph[y][x];
        }

        for (int i = 0; i < height; i++) {
            x--;
            y++;
            if (!isInBounds(x, y)) return;
            sum += graph[y][x];
        }
        
        for (int i = 1; i < width; i++) {
            x--;
            y--;
            if (!isInBounds(x, y)) return;
            sum += graph[y][x];
        }
        
        for (int i = 1; i < height; i++) {
            x++;
            y--;
            if (!isInBounds(x, y)) return;
            sum += graph[y][x];
        }
        
        max = Math.max(max, sum);
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}