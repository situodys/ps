package ps.백준.바킹독.bst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 문제_추천_시스템_Version2 {

    public static int n, m;
    public static int[] arr;
    public static TreeMap<Integer, TreeSet<Problem>> problemsByAlgo = new TreeMap<>();
    public static TreeMap<Integer,Problem> problemMap = new TreeMap<>();
    public static TreeSet<Problem> problemSet = new TreeSet<>();
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        int diff,no,algo;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            no = Integer.parseInt(st.nextToken());
            diff = Integer.parseInt(st.nextToken());
            algo = Integer.parseInt(st.nextToken());

            add(no, diff, algo);
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                no = Integer.parseInt(st.nextToken());
                diff = Integer.parseInt(st.nextToken());
                algo = Integer.parseInt(st.nextToken());
                add(no, diff, algo);

            } else if (order.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                TreeSet<Problem> ps = problemsByAlgo.get(g);
                if (x == 1) {
                    sb.append(ps.last().no).append('\n');
                }else{
                    sb.append(ps.first().no).append('\n');
                }
            } else if (order.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(problemSet.last().no).append('\n');
                }else{
                    sb.append(problemSet.first().no).append('\n');
                }
            } else if (order.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    Problem ceiling = problemSet.ceiling(new Problem(0, l, 1));
                    if (ceiling == null) {
                        sb.append(-1).append('\n');
                    }else sb.append(ceiling.no).append('\n');
                }else{
                    Problem floor = problemSet.floor(new Problem(0, l, 1));
                    if (floor == null) {
                        sb.append(-1).append('\n');
                    }else sb.append(floor.no).append('\n');
                }
            }else{
                int p = Integer.parseInt(st.nextToken());
                Problem pb = problemMap.get(p);
                problemMap.remove(p);
                problemSet.remove(pb);
                problemsByAlgo.get(pb.algo).remove(pb);
            }
        }

        System.out.println(sb);
    }

    private static void add(int no, int diff, int algo) {
        TreeSet<Problem> problems = problemsByAlgo.getOrDefault(algo, new TreeSet<>());
        Problem problem = new Problem(no, diff, algo);
        problems.add(problem);
        problemsByAlgo.put(algo, problems);
        problemMap.put(no, problem);
        problemSet.add(problem);
    }

    private static class Problem implements Comparable<Problem> {
        public int no;
        public int diff;
        public int algo;

        public Problem(int no, int diff, int algo) {
            this.algo = algo;
            this.no = no;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.diff == o.diff) {
                return this.no - o.no;
            }
            return this.diff - o.diff;
        }
    }
}
