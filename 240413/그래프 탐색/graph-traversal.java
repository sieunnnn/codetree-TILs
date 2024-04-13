import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Set<Integer> finalNode = new HashSet<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        for(int i = 0; i < N; i++) {
            Collections.sort(graph.get(i));
        }

        solve(0);
        System.out.println(cnt);
    }
    
    public static void solve(int currentNode) {
        visited[currentNode] = true;

        for(Integer nextNode : graph.get(currentNode)) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                cnt++;
                solve(nextNode);
            }
        }
    }
}