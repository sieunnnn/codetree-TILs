import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[101][101];
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    static int max = 0;
    static int[][] directionMap = new int[][] {
            {UP, DOWN, LEFT, RIGHT},
            {RIGHT, LEFT, DOWN, UP},
            {LEFT, RIGHT, UP, DOWN}
    };
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            // DOWN
            solve(DOWN, 0, i, 1);
            // UP
            solve(UP, N-1, i, 1);
            // LEFT
            solve(LEFT, i, N-1, 1);
            // RIGHT
            solve(RIGHT, i, 0, 1);
        }
        System.out.println(max);
    }
    public static void solve(int direction, int i, int j, int acc) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            max = Math.max(max, acc);
            return;
        }
        int nextDirection = findNextDirection(direction, arr[i][j]);
        int[] nextPosition = findNextPosition(nextDirection, i, j);
        solve(nextDirection, nextPosition[0], nextPosition[1], acc + 1);
    }
    public static int findNextDirection (int direction, int kind) {
        return directionMap[kind][direction];
    }
    public static int[] findNextPosition (int direction, int i, int j) {
        int[] ret = new int[] {i, j};
        if (direction == UP) {
            ret[0]--;
        } else if (direction == DOWN) {
            ret[0]++;
        } else if (direction == LEFT) {
            ret[1]--;
        } else if (direction == RIGHT) {
            ret[1]++;
        }
        return ret;
    }
}