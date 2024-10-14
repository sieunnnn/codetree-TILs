import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] graph;
    static boolean[] visited;
    static boolean[] checked;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        checked = new boolean[n + 1];
        graph = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                graph[i + 1] = input;
            }
        }

        solve();

        System.out.println(count);
    }

    public static void solve() {
        for (int i = 1; i <= n; i++) {
            if (!checked[i]) bfs(i);
        }
    }

    public static void bfs(int start) {
        visited = new boolean[n + 1];
        List<Integer> path = new ArrayList<>();
        boolean isCycle = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        path.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = graph[current];

            if (next == 0 || visited[next]) {
                if (visited[next] && path.contains(next)) {
                    isCycle = true;
                }
                break;
            }

            queue.add(next);
            visited[next] = true;
            path.add(next);
        }

        if (!isCycle) {
            countNode(path);
        }
    }

    public static void countNode(List<Integer> path) {
        for (int node : path) {
            if (!checked[node]) {
                checked[node] = true;
                count++;
            }
        }
    }
}