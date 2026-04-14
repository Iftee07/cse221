    import java.io.*;
    import java.util.*;

    public class adjList {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] u = new int[M];
            int[] v = new int[M];
            int[] x = new int[M];

            ArrayList<int[]>[] adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<int[]>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                adj[u[i]].add(new int[] { v[i], x[i] });
            }

            for (int i = 1; i <= N; i++) {
                pw.print(i + ": ");
                for (int[] edge : adj[i]) {
                    pw.print("(" + edge[0] + "," + edge[1] + ") ");
                }
                pw.println();
            }
            pw.flush();

        }
    }
