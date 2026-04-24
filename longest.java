
import java.io.*;
import java.util.*;

public class longest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new java.io.PrintWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N == 1) {
            pw.println(0);
            pw.println("1 1");
            pw.close();
            return;
        }

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        int dist[] = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        int highest = -1;
        int max_dist = -1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : graph[curr]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    if (dist[neighbor] > max_dist) {
                        max_dist = dist[neighbor];
                        highest = neighbor;
                    }
                    q.add(neighbor);
                }
            }
        }
        q.add(highest);
        Arrays.fill(dist, -1);
        int highest1 = highest;
        dist[highest1] = 0;
        max_dist = -1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : graph[curr]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    if (dist[neighbor] > max_dist) {
                        max_dist = dist[neighbor];
                        highest1 = neighbor;
                    }
                    q.add(neighbor);
                }
            }
        }
        pw.println(max_dist);
        pw.print(highest);
        pw.print(" " + highest1);
        pw.close();
    }
}
