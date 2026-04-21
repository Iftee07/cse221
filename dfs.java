import java.io.*;
import java.util.*;

public class dfs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            pw.print(curr + " ");
            for (int vertex : graph[curr]) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    q.add(vertex);
                }
            }
        }
        pw.flush();
    }
}
