import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<String, String> map1 = new HashMap<>();
    static Map<String, String> map2 = new HashMap<>();

    static int N;
    static int maxTime = Integer.MIN_VALUE;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initMaps();

        for (int i = 0; i < N; i++) {
            findMaxTime(0, i, "right", 1, true);
            findMaxTime(i, 0, "down", 1, true);
            findMaxTime(N - 1, i, "left", 1, true);
            findMaxTime(i, N - 1, "up", 1, true);
        }

        System.out.println(maxTime);
    }

    public static void initMaps() {
        map1.put("up", "right");
        map1.put("down", "left");
        map1.put("left", "down");
        map1.put("right", "up");

        map2.put("up", "left");
        map2.put("down", "right");
        map2.put("left", "up");
        map2.put("right", "down");
    }

    public static void findMaxTime(int x, int y, String direction, int time, boolean start) {
        if (!start)  {
            if (x < 0 || x >= N || y < 0 || y >= N) {
                maxTime = Math.max(maxTime, time);
                return;
            }
        }

        int currentValue = graph[y][x];
        String nextDirection = findNextDirection(currentValue, direction);

        if (nextDirection.equals("up")) {
            findMaxTime(x, y - 1, nextDirection, time + 1, false);

        } else if (nextDirection.equals("down")) {
            findMaxTime(x, y + 1, nextDirection, time + 1, false);

        } else if (nextDirection.equals("left")) {
            findMaxTime(x - 1, y, nextDirection, time + 1, false);

        } else if (nextDirection.equals("right")) {
            findMaxTime(x + 1, y, nextDirection, time + 1, false);
        } else {
            System.out.println("!!");
        }
    }

    public static String findNextDirection(int currentValue, String direction) {
        String nextDirection = "";

        if (currentValue == 0) {
            nextDirection = direction;

        } else if (currentValue == 1) {
            nextDirection = map1.get(direction);

        } else if (currentValue == 2) {
            nextDirection = map2.get(direction);
        } else {
            System.out.println("!!!!!");
        }

        return nextDirection;
    }
}