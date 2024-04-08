import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxPairs = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int[][] tempMap = deepCopyMap(map);
                explodeBomb(tempMap, x, y);
                applyGravity(tempMap);
                maxPairs = Math.max(maxPairs, countPairs(tempMap));
            }
        }

        System.out.println(maxPairs);
    }

    private static int[][] deepCopyMap(int[][] original) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    private static void explodeBomb(int[][] tempMap, int x, int y) {
        int bombRange = tempMap[y][x];
        tempMap[y][x] = 0; // 폭탄이 터진 자리 -> 0

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < bombRange; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    tempMap[ny][nx] = 0;
                }
            }
        }
    }

    private static void applyGravity(int[][] tempMap) {
        for (int x = 0; x < n; x++) {
            for (int y = n - 1; y >= 0; y--) {
                if (tempMap[y][x] == 0) {
                    for (int k = y - 1; k >= 0; k--) {
                        if (tempMap[k][x] != 0) {
                            tempMap[y][x] = tempMap[k][x];
                            tempMap[k][x] = 0; // 사용한거 0 으로 변경
                            break;
                        }
                    }
                }
            }
        }
    }

    private static int countPairs(int[][] grid) {
        int pairs = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - 1; x++) {
                if (grid[y][x] != 0 && grid[y][x] == grid[y][x + 1]) {
                    pairs++;
                }
            }
        }

        for (int y = 0; y < n - 1; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] != 0 && grid[y][x] == grid[y + 1][x]) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
}