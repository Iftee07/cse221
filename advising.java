import java.io.*;
import java.util.*;

public class advising {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new java.io.PrintWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int k = 1; k < n + 1; k++) {
                graph[k] = new ArrayList<>();
            }
            int[] inDegree = new int[n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                inDegree[b]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int k = 1; k < n + 1; k++) {
                if (inDegree[k] == 0) {
                    q.add(k);
                }
            }
            int count = 0;
            ArrayList<Integer> output = new ArrayList<>();
            while (!q.isEmpty()) {
                Integer f = q.remove();
                output.add(f);
                count++;

                for (int neighbor : graph[f]) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }

            }
            if (count == n) {
                for (int num : output) {
                    pw.print(num + " ");
                }
                pw.println();
            } else {
                pw.println(-1);
            }
        }
        pw.flush();

    }
}