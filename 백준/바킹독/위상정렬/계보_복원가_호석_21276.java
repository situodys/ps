package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 계보_복원가_호석_21276 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static Map<String, Integer> mp;
    public static Map<Integer, String> mpByIdx;
    public static int[] indegree;
    public static List<Integer>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        List<String> names = new ArrayList<>();
        mp = new HashMap<>();
        mpByIdx = new HashMap<>();
        indegree = new int[n + 1];

        edges = new List[n + 1];
        List<String>[] result = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            String name = st.nextToken();
            mp.put(name, i);
            mpByIdx.put(i, name);
            names.add(name);
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            indegree[mp.get(child)]++;
            edges[mp.get(parent)].add(mp.get(child));
        }

        List<String> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                answer++;
                roots.add(mpByIdx.get(i));
            }
        }
        System.out.println(answer);

        roots.sort(Comparator.naturalOrder());
        for (String root : roots) {
            System.out.print(root+" ");
        }
        System.out.println();

        Queue<Integer> q = new LinkedList<>();
        for (String root : roots) {
            q.offer(mp.get(root));
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer child : edges[cur]) {
                    if (indegree[child] - indegree[cur] == 1) {
                        result[cur].add(mpByIdx.get(child));
                        q.offer(child);
                    }
                }
            }
        }

        names.sort(Comparator.naturalOrder());
        for (List<String> nms : result) {
            nms.sort(Comparator.naturalOrder());
        }

        for (String key : names) {
            System.out.print(key+" "+result[mp.get(key)].size()+" ");
            for (String s : result[mp.get(key)]) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
