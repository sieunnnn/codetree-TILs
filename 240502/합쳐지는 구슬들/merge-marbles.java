import java.util.*;
import java.io.*;

class Ball {
    int x, y, direction, weight, id;

    public Ball(int x, int y, int direction, int weight, int id) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.weight = weight;
        this.id = id;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<String, Integer> directions = new HashMap<>();
    static List<Ball> balls = new ArrayList<>();

    static int n, m, t;
    static int[][][] graph;

    public static void main(String[] args) throws IOException {
        initMap();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new int[n][n][3]; // weight, direction, id

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());
            int id = i + 1;

            graph[x][y][0] = weight;
            graph[x][y][1] = directions.get(dir);
            graph[x][y][2] = id;
            
            balls.add(new Ball(x, y, directions.get(dir), weight, id));
        }

        solve();
        printResults();
    }

    public static void initMap() {
        directions.put("U", -1); // up
        directions.put("D", 1);  // down
        directions.put("L", -2); // left
        directions.put("R", 2);  // right
    }

    public static void solve() {
        for (int time = 0; time < t; time++) {
            int[][][] newGraph = new int[n][n][3];
            
            for (Ball ball : new ArrayList<>(balls)) {
                int y = ball.x;
                int x = ball.y;
                int direction = ball.direction;

                if (x == 0 && direction == -2 || x == n - 1 && direction == 2) { // 가로
                    direction *= -1;
                    
                } else if (y == 0 && direction == -1 || y == n - 1 && direction == 1) { // 세로
                    direction *= -1;
                    
                } else {
                    graph[y][x][0] = 0; // 이전 기록 삭제
                    
                    if (direction == 1) y++;
                    else if (direction == -1) y--;
                    else if (direction == 2) x++;
                    else if (direction == -2) x--;
                }

                if (newGraph[y][x][0] > 0) { // 충돌
                    newGraph[y][x][0] += ball.weight;
                    
                    if (ball.id > newGraph[y][x][2]) {
                        newGraph[y][x][1] = direction;
                        newGraph[y][x][2] = ball.id;
                    }
                    
                } else {
                    newGraph[y][x][0] = ball.weight;
                    newGraph[y][x][1] = direction;
                    newGraph[y][x][2] = ball.id;
                }
            }
            
            graph = newGraph;
            balls.clear();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j][0] > 0) {
                        balls.add(new Ball(i, j, graph[i][j][1], graph[i][j][0], graph[i][j][2]));
                    }
                }
            }
        }
    }

    public static void printResults() {
        int count = 0;
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j][0] > 0) {
                    count++;
                    maxWeight = Math.max(maxWeight, graph[i][j][0]);
                }
            }
        }
        System.out.println(count + " " + maxWeight);
    }
}