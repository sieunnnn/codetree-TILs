import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    static int[][] graph;
    static int[][] bombSite;
    static int[][] newGraph;

    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0}; 

    static int max_count = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkBombSite(i, j, graph[i][j]);
                drawNewGraph();
                findMaxPairNumber();
            }
        }

        System.out.println(max_count);
    }

    // 폭탄 터진 자리
    public static void checkBombSite(int y, int x, int range) {
        bombSite = new int[n][n];
        bombSite[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < range; j++) {
                int ny = y + dy[i] * j;
                int nx = x + dx[i] * j;

                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    bombSite[ny][nx] = 1;
                }
            }
        }
    }

    // 새로운 그래프 그리기
    public static void drawNewGraph() {
        newGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            int writeRow = n - 1;

            for (int j = n - 1; j >= 0; j--) {
                if (bombSite[j][i] != 1) {
                    newGraph[writeRow--][i] = graph[j][i];
                }
            }
        }
    }

    // 짝 찾기
    public static void findMaxPairNumber() {
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (newGraph[i][j] == newGraph[i][j + 1] && newGraph[i][j] != 0) {
                    cnt++;
                }

                if (newGraph[j][i] == newGraph[j + 1][i] && newGraph[j][i] != 0) {
                    cnt++;
                }
            }
        }

        max_count = Math.max(max_count, cnt);
    }
}