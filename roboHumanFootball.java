import java.io.*;
import java.util.*;

public class roboHumanFootball {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new java.io.PrintWriter(new java.io.OutputStreamWriter(System.out));

        String line = br.readLine();
        if (line == null)
            return;
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] color = new int[N + 1];
        Arrays.fill(color, -1);
        int max = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (color[i] == -1) {
                int count0 = 0;
                int count1 = 0;

                color[i] = 0;
                count0++;
                q.add(i);

                while (!q.isEmpty()) {
                    int f = q.poll();
                    for (int neighbor : graph[f]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[f];
                            if (color[neighbor] == 0) {
                                count0++;
                            } else {
                                count1++;
                            }
                            q.add(neighbor);
                        }
                    }
                }
                max += Math.max(count0, count1);
            }
        }
        pw.println(max);
        pw.flush();
        pw.close();
    }
}